# 프록시 패턴

사전적 의미로는 대리자 라는 뜻을 가지고 있다.

단어로 유추해보자면 이 프록시로 하여금 다른 일을 수행하게끔 해주는 패턴이라고 할 수 있다.

실제로 무엇인가를 구현하고 있는 객체를 뒤로 숨기고

프록시를 앞으로 내세워 접근을 제어한다.

실제적으로 비용이 많이 들어가는 처리를 할 때 객체를 만들도록 한다 (**FlyWeight Pattern**)

## 클래스 다이어그램

![image](https://user-images.githubusercontent.com/74235102/141420673-e56a961b-168e-4f67-9158-8105993c954b.png)

이 구조로 되어있다.

모든 패턴이고 클라이언트는 인터페이스를 참조해야 한다.

인터페이스로 하여금 어떠한 것을 실행하게끔 해줘야 한다.

`Subject` 클래스의 어떤 행위를 `Proxy`와 `RealSubject` 둘다 구현하지만

그 구현을 `Proxy`가 `RealSubject` 대신 해주는것이다.

이렇게 하면 **흐름제어**가 가능하다는 것이다.

## 예시

> Subject.java

```java
public interface Subject {
    void doAction();
}
```

> RealSubject.java

```java
public class RealSubject implements Subject {

    private final String behavior;

    public RealSubject(final String behavior) {
        this.behavior = behavior;
    }

    @Override
    public void doAction() {
        System.out.println(behavior + " Action of RealSubject");
    }
}
```

> Proxy.java

```java
public class Proxy implements Subject {

    private final String behavior;
    private Subject subject;

    public Proxy(final String behavior) {
        this.behavior = behavior;
    }

    @Override
    public void doAction() {
        //이 부분에서 doAction의 예외처리나 어떤 분기를 걸어준다면?
        subject = new RealSubject(behavior);
        subject.doAction();
    }

}
```

> Main.java

```java
public class Main {

    public static void main(String[] args) {
        Subject subject = new Proxy("run!!!");
        subject.doAction();
    }

}
```

![image](https://user-images.githubusercontent.com/74235102/141421608-3c7b64cd-7952-4ba8-a0b5-0071fb7d272a.png)

결과는 위처럼 출력된다.

## 마무리

이런 패턴이 JPA에서 많이 볼 수 있었는데 그게 JPA의 프록시 이다.

막연하게 `가짜 객체`라고 해서 어떤 추상의 무언가를 내포하고 있을 줄 알았지만

구현을 해놓은 것이지 가져다가 뭘 하지는 않는다는 것이었고 리얼 구현에 대한것을

잘 포장해줬던 객체라고 이해를 하니 재밌다.

주석처리한 부분에서 캐시를 사용해서 캐시가 있다면 캐시를,

없다면 생성하는 시간이 오래 걸리면서 빼오게끔 설계할 것이라고 생각한다.

여러가지로 많이 쓰이는 패턴이다.