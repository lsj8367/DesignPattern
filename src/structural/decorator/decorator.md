# 데코레이터 패턴

장식과 실제 내용물을 동일시

객체에 동적으로 책임을 추가하는 패턴이다.

이 데코레이터가 뭔가 좀 구현해보면서 느꼈는데,

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}
```

이 코드에서 `new BufferedReader(new InputStreamReader(System.in))`

이 부분이 바로 데코레이터 패턴이 적용된 것이다.

결국 구현체인 `System.in`을 꾸며주려고  `InputStreamReader`, `BufferedReader`가 꾸며준 것이다.

예제를 직접 짜보니까 조금 많이 이해가 되었다.

### 클래스 다이어그램

![스크린샷 2021-09-19 오후 3 52 49](https://user-images.githubusercontent.com/74235102/133918452-14cd7a4b-77ff-4295-9d99-2f12412259fc.png)

클래스 다이어그램을 보면 위와 같다.

이 패턴의 핵심인 `Decorator`로의 조합을 통해 계속 기능을 추가해 나갈 수 있는 패턴이다.

커피로 예시를 들면

원초적인 커피의 기본이 되는 에스프레소가 있다.

이 에스프레소에 물을 넣으면 아메리카노, 그 다음 우유를 섞으면 라떼... 등등

이렇게 점점 하나씩 추가하여 꾸며주는 패턴이 데코레이터 패턴이었다.

아래에서 예제를 한번 설명해보겠다.

```java
import structural.decorator.Coffee;
import structural.decorator.Columbia;

public class Main {
    Coffee ethiopia = new Columbia();
}
```

이렇게 했을 경우에는 콜롬비아 에스프레소가 만들어진다.

커피를 아메리카노로 만들고 싶다면

```java
import structural.decorator.Americano;
import structural.decorator.Coffee;
import structural.decorator.Columbia;

public class Main {
    Coffee columbiaAmericano = new Americano(new Columbia());
}
```

이렇게 하면 되는 것이다.


## 정리

객체의 결합 을 통해 기능을 동적으로 유연하게 확장 할 수 있게 해주는 패턴

즉, 기본 기능에 추가할 수 있는 기능의 종류가 많은 경우에 각 추가 기능을 Decorator 클래스로 정의 한 후에 

필요한 Decorator 객체를 조합함으로써 추가 기능의 조합을 설계 하는 방식이다.

**데코레이터 패턴을 이용하여 필요 추가 기능의 조합을 동적으로 생성할 수 있다.**