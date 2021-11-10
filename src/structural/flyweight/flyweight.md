# 플라이웨이트 패턴

이 패턴은 데이터를 서로 공유하여 메모리 사용량을 최소화 하는 패턴이다.

`JDBC`를 생각하면 이해가 될지도? 모르겠다.

일단 객체 인스턴스화 하는 비용이 많이드는 것들을 이 패턴을 적용하면 성능이 향상될 것같다.

생성하려는 객체가 이미 생성되어있다면 그 객체를,

아니라면 새로 생성해서 저장해둔다.

이 패턴을 적용하는 객체는 `불변`이 가장 중요하다.

이 상태들에 대한 작업은 `팩토리패턴`을 적용시켜 팩토리에서 수행하는 것이 바람직할 것이다.

## 클래스 다이어그램

![image](https://user-images.githubusercontent.com/74235102/141067756-511c5878-d54b-4f1b-b798-c604714e18f1.png)

클래스 다이어그램에서 보면

플라이웨이트 팩토리가 플라이웨이트 객체들을 만드는것을 관리해주는데

그 연결을 `Connection Pool`에서 맺고 끊어준다.

위에서 잠깐 말했듯, `DB connection pool` 연결하는 구조와 비슷한것 같다.

끊어주고 다른 DB접속하려면 pool을 새로 만들어주거나 추가하는 구조로 가는 느낌이다.

한번 연결해두면 또 다른 클래스에서 참조하여 사용이 가능하고

DB연결은 생성비용이 많이 비싸다.

## 예시

> Vehicle.java

```java
public interface Vehicle {

    void start();

    void stop();

    Color getColor();

}
```

> Engine.java

```java
public class Engine {

    public void start() {
        System.out.println("Engine Start");
    }

    public void stop() {
        System.out.println("Engine Stop");
    }

}
```


> Car.java

```java
public class Car implements Vehicle {
    private Engine engine;
    private Color color;

    public Car(final Engine engine, final Color color) {
        this.engine = engine;
        this.color = color;

        try {
            //생성비용이 비싼거라는것으로 시간초로 할당
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void start() {
        engine.start();
    }

    @Override
    public void stop() {
        engine.stop();
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Car car = (Car) o;
        return Objects.equals(engine, car.engine) && Objects.equals(color,
            car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engine, color);
    }
}
```

> VehicleFactory.java

```java
public class VehicleFactory {
    private static Map<Color, Vehicle> vehicleMap = new HashMap<>();

    public static Vehicle createVehicle(Color color) {
        Vehicle newVehicle = vehicleMap.computeIfAbsent(color, VehicleFactory::of);
        return newVehicle;
    }

    private static Vehicle of(Color newColor) {
        Engine newEngine = new Engine();
        return new Car(newEngine, newColor);
    }
}
```

> Main.java

```java
public class Main {

    public static void main(String[] args) {
        Vehicle blackVehicle = VehicleFactory.createVehicle(Color.BLACK);
        Vehicle blueVehicle = VehicleFactory.createVehicle(Color.BLUE);

        System.out.println("둘이 다른 객체일때");

        System.out.println(Objects.isNull(blackVehicle));
        System.out.println(Objects.isNull(blueVehicle));
        System.out.println(blackVehicle == blueVehicle);




        Vehicle redVehicle = VehicleFactory.createVehicle(Color.RED);
        Vehicle anotherRedVehicle = VehicleFactory.createVehicle(Color.RED);

        System.out.println("둘이 같은 객체일 때");

        System.out.println(Objects.isNull(redVehicle));
        System.out.println(Objects.isNull(anotherRedVehicle));
        System.out.println(redVehicle == anotherRedVehicle);
    }

}
```
![image](https://user-images.githubusercontent.com/74235102/141074880-3abd589d-90d9-4913-82a2-73474a501009.png)

일단 객체는 생성이되서 처음 두개는 false를 출력해준다.

Map에 해당하는 컬러들을 넣어서 값을 가져오기 때문에

다른 키값이면 새로 생성을 해주고

아니라면 생성했던 객체를 뒤져 찾아서 반환해준다.