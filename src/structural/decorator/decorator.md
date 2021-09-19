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

커피로 예시를 들면

원초적인 커피의 기본이 되는 에스프레소가 있다.

이 에스프레소에 물을 넣으면 아메리카노, 그 다음 우유를 섞으면 라떼... 등등

이렇게 점점 하나씩 추가하여 꾸며주는 패턴이 데코레이터 패턴이었다.