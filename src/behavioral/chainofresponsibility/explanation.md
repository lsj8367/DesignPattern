# Chain Of Responsibility Pattern

책임-연쇄 패턴

책임 떠넘기기 패턴

다수의 객체를 사슬처럼 연결한다.

요청을 처리할 수 있는 기회를 하나 이상의 객체에게 부여해준다.

요청을 해결할 객체를 만날 때까지 객체 고리를 따라 요청을 전달한다.

## 클래스 다이어그램

![image](https://user-images.githubusercontent.com/74235102/140846720-0c202fba-beb1-40f7-b562-1f7344c6822d.png)



스프링 프레임워크 안에서 이 패턴을 생각해봤는데

`Filter` 부분이나 `Handler`쪽에서 사용할 것이다.

여러개의 `Filter Chain`들을 지나면서 기능들을 수행하기 때문에

이것의 원초적인 것은 바로 `서블릿 필터` 이다.

잠시 구조를 보면

```java
public class CustomFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // process the request
        // pass the request (i.e. the command) along the filter chain
        chain.doFilter(request, response);
    }
}
```

이런식으로 구조가 잡혀있고 저 `doFilter()` 를 통해 다음 필터를 호출한다.

단점은

- 쉽게 끊어질 수 있다.
- 프로세서가 다음 프로세서를 호출하는 데 실패하면 명령이 삭제된다.
  - 어느 특정 요청을 어떤 객체가 처리할지는 모른다.
  - 그래서 요청이 처리된다는 보장도 없다.
- 프로세서 간에 코드가 중복되어 유지보수 비용이 증가할 수 있다.