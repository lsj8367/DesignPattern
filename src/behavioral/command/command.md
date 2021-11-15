# 커맨드 패턴

커맨드 패턴은 객체의 행위를 클래스로 만들어 캡슐화 하는 패턴이다.

어떤 객체에서 다른 객체의 메소드를 실행하려고 한다면

그 객체를 참조하고 있어야 된다.

이러면 의존성이 발생하게 되는데 이를 제거하기 위해서 커맨드 패턴을 사용한다.

요구사항에 대해 수정, 변경이 진행될 때 사용하고자 하는 객체의 코드를

수정하지 않고 오로지 기능에 대해서만 구현해주면 확장성이 있으며 유연해진다.

## 클래스 다이어그램

![image](https://user-images.githubusercontent.com/74235102/141706946-03dd09d5-eee9-42fb-97b2-810383a0d7a6.png)

## 예시

나는 집에있던 기가지니를 떠올려서 예를 들어본다.

기가지니한테 명령이 TV를 키고 끄는 명령어만 존재했다면,

형광등 불 꺼달라는 요구사항이 생겼을 때를 가정한다.

> Command.java

```java
public interface Command {

    void execute();
}
```

> Tv.java

```java
public class Tv {

    public void turnOn() {
        System.out.println("TV를 킨다.");
    }

}
```

> TvCommand.java

```java
public class TvCommand implements Command {

    private final Tv tv;

    public TvCommand(final Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }
}
```

이렇게 되면 TV 켜는 기능이 정의 되었다.

> GigaGenie.java

```java
public class GigaGenie {

    private Command command;

    public void talk() {
        command.execute();
    }

    public void setCommand(final Command command) {
        this.command = command;
    }
}
```

> Client.java

```java
public class Client {

    public static void main(String[] args) {
        TvCommand tvCommand = new TvCommand(new Tv());
        GigaGenie gigaGenie = new GigaGenie();
        gigaGenie.setCommand(tvCommand);
        gigaGenie.talk();
    }
}
```

클라이언트 클래스를 잠시 보면 예전에 구현했었던 데코레이터 패턴이 보인다.

`Tv`를 꾸며주는 `TvCommand` 그렇게 해서 기가지니 `Command`에 `TvCommand`객체를 주입시킨다.

그렇게해서 Tv를 켜게 해준다.

여기서 위에서의 요구사항인 불을 꺼라 라는 요구사항을 추가한다면?

> Lamp.java

```java
public class Lamp {

    public void turnOff() {
        System.out.println("불을 끈다.");
    }
}
```

> LampCommand.java

```java
public class LampCommand implements Command {

    private final Lamp lamp;

    public LampCommand(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        lamp.turnOff();
    }
}
```

이러면 해당 요구사항 구현이 끝났다.

기가지니의 명령 설정에서 `setCommand(lampCommand);` 가 되면 끝인거다.

그래서 다시 클라이언트로 돌아와 명령을 추가하면

```java
public class Client {

    public static void main(String[] args) {
        TvCommand tvCommand = new TvCommand(new Tv());
        GigaGenie gigaGenie = new GigaGenie();
        gigaGenie.setCommand(tvCommand);
        gigaGenie.talk();

        LampCommand lampCommand = new LampCommand(new Lamp());
        gigaGenie.setCommand(lampCommand);
        gigaGenie.talk();
    }
    
}
```

## 결과

![image](https://user-images.githubusercontent.com/74235102/141708432-0f220980-3dce-45d2-a9dc-a9de1f5cbd8b.png)
