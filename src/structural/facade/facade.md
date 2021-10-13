# 퍼사드 패턴

어떤 서브 시스템들의 일련의 인터페이스에 대한 통합된 인터페이스 제공

자바의 컴파일러나 `main`메소드를 실행할 때를 생각해보면 될 것 같다.

![image](https://user-images.githubusercontent.com/74235102/137049770-7dae8e47-4b91-42a1-b52e-ae8fefb1bc53.png)

이 퍼사드에서 고수준의 인터페이스를 정의하기 때문에 서브 시스템을 더 쉽게 사용할 수 있다.

어댑터 패턴과 많이 비슷해보이는데 두개의 차이점은,

- 어댑터 패턴: 인터페이스를 다른 인터페이스로 변환시키기 위한 용도
- 퍼사드 패턴: 인터페이스를 단순화시키기 위한 용도

가만보니까 `Spring MVC`패턴하고 많이 비슷하다는 생각이 자꾸 든다.

컨트롤러에서 서비스를 호출하면 서비스가 알아서 쭉쭉 뭔가를 해주지않은가?

서비스에서는 로직을 가지면 안되며 로직은 각각 `도메인`이 가져야 하게끔 설계를 계속 하려고 해야한다.

## 클래스 다이어그램

클래스 다이어그램을 보면 전부 추상화가 되어있고 퍼사드에서 호출하면 하위의 기능들을 전부 수행시킬 수 있게 된다.

![image](https://user-images.githubusercontent.com/74235102/137049878-c8ff205c-c8d5-4abd-9149-6acf364ca414.png)


## 예제

> Speak.java

```java
public class Speak {
    public void speak() {
        System.out.println("말하기");
    }
}

public class Write {
    
    private final String message;

    public Write(String message) {
        this.message = message;
    }

    public void write() {
        System.out.println("쓰기 내용 : " + message);
    }
}

public class Read {
    public void read() {
        System.out.println("읽기");
    }
}
```

> Facade.java

```java
public class Facade {
    private final Speak speck;
    private final Write write;
    private final Read read;
    
    public Facade() {
        this.speck = new Speak();
        this.write = new Write("요기에 쓸내용");
        this.read = new Read();
    }
    
    public void doSomething() {
        speck.speak();
        write.write();
        read.read();
    }
}
```

> Main.java

```java
public class Main {

    public static void main(String[] args) {
        Facade facade = new Facade();
        
        facade.doSomething();
    }
}
```

이런식으로 MVC를 생각하면 Facade 클래스가 서비스가 되는것이다.

도메인 3개를 호출해서 특정 작업을 수행하게 된다.