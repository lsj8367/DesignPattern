# 옵저버 패턴

옵저버 음 어디에 비유해야 할지 잘 모르겠었는데, 스타크래프트의 옵저버를 떠올려보면 된다.

프로토스 종족은 이 유닛으로 상대방의 유닛들을 관찰할 수가 있는데,

옵저버 패턴도 객체의 상태변화를 관찰할 수 있는 패턴이다.

즉 옵저버들의 목록을 객체에 등록하여 상태 변화가 있을 때마다 메서드 등을 통해

객체가 직접 목록의 각 옵저버에게 통지하도록 하는 디자인 패턴이다.

주로 분산 이벤트 핸들링 시스템을 구현하는 데 사용된다. 발행/구독 모델로 알려져 있기도 하다.

- 하나의 객체에 연동되는 여러 객체 집합이 있을 때 변화에 대한 일관성은 유지하고, 객체간의 결합도는 낮게하기 위한 패턴
- 변화에 관심이 있는 객체에 대한 가정없이 통보될 수 있도록 해야 함
- 주로 data - view 의 관계에서 사용됨
- log와 그 handler들의 관계. (file, console, 등등)

## 클래스 다이어그램

![스크린샷 2021-10-05 오후 9 55 21](https://user-images.githubusercontent.com/74235102/136026739-fcc82939-7a7f-4c1d-81db-33e40a489288.png)

클래스 다이어그램은 위와 같다.

- Subject
  - Observer를 알고 있는 주체, Observer를 더하거나 뺄수 있음
- Observer
  - Subject의 변화에 관심을 가지는 객체, 갱신에 필요한 인터페이스 정의, 객체들의 일관성을 유지
- ConcreteSubject
  - ConcreteObserver에게 알려주어야하는 상태가 변경될때 통보 (주로 List로 Observer관리)
- ConcreteObserver
  - 객체에 대한 참조자를 관리하고, Subject의 일관성 유지하며, Subject가 변경될 때 갱신되는 인터페이스 구현

구현한 예제에서는 `Subject`에 해당하는 클래스는 `NumberGenerator`, 

구현체인 `ConcreteSubject`는 `RandomNumberGenerator`가 된다.

> Observer.java
```java
public interface Observer {
    void update(NumberGenerator numberGenerator);
}
```

> GraphObserver.java

```java
public class GraphObserver implements Observer {

    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.println("GraphObserver");
        int number = numberGenerator.getNumber();

        for (int i = 0; i < number; i++) {
            System.out.print("*");
        }

        System.out.println();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

나온 숫자만큼 `*`을 찍는 update메소드를 구현

> DigitObserver.java

```java
public class DigitObserver implements Observer {

    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.println("DigitObserver: " + numberGenerator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

나온 숫자를 출력해주는 update 구현

> NumberGenerator.java

```java
public abstract class NumberGenerator {

    private final ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public abstract int getNumber();
    public abstract void execute();
}
```

추가된 옵저버들에 대해 같은 기능을 수행하게끔 해주기 위해서 메소드를 구현해놓음과 동시에

다형성으로 처리해야하는 메소드들은 추상메소드로 정의를 해서 처리했다.

> RandomNumberGenerator.java

```java
public class RandomNumberGenerator extends NumberGenerator {

    private final Random random = new Random();
    private int number;

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 50; i++) {
            number = random.nextInt(50);
            notifyObservers();
        }
    }
}
```

랜덤 값을 받은 값만큼 `*`을 찍고, 숫자가 몇인지 출력해주는 옵저버 두개를 업데이트한다.

어떤 매개변수의 인자에 따라 상황에 맞는 뷰를 리턴해주는 형식으로 진행되는 로직에 구현이 수월할 것 같다.