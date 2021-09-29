# 어댑터 패턴

원래 쓰는 인터페이스 + 기능을 제공하는 클래스

이 사이에서 호환하게끔 해주는 패턴이 어댑터 패턴이다.

전기 코드 어댑터를 생각하면 될것 같다.

220V를 110V 포트에 꼽으려고 할때 컨버터를 사용해서 이어주듯이

어댑터도 그렇게 연결을 해주는 것이다.

이 패턴에는 두가지 방법이 있다.

- 어댑터 패턴은 상속을 활용하는 방법
- 합성 방법으로 구현하는 방법

**상속 방법**
![image](https://user-images.githubusercontent.com/74235102/135235403-57e6f2e7-037e-47e6-82fe-ded6e27e759a.png)

**합성 방법**
![image](https://user-images.githubusercontent.com/74235102/135235477-e1cf4fe5-2eaa-4564-8c7d-aae1169eccf5.png)

구현한 코드로 설명을 하자면,

우선 어떤 단어를 강조하는 법, 괄호를 치는 법 이렇게 있다고 가정한다.

근데 이 단어들을 이용하는 로직이 있어서 바꿀수는 없다.

방식을 바꿔야 하는 것이다.

요구사항으로 글씨체 진하게, 글씨체 가늘게 이렇게 바꿔서 출력을 해야한다는

조건이 있을때를 가정하여 구현한 것이다.

> Print.java (최종 출력해야 하는 인터페이스)

```java
public interface Print {
    void printWeak();
    void printStrong();
}
```

> Banner.java 기본 출력형식

```java
public class Banner {

    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    public void showWithAster() {
        System.out.println("**" + string + "**");
    }
}
```

### 상속 구현의 경우

> PrintBanner.java

```java
public class PrintBanner extends Banner implements Print {
    
    public PrintBanner(String string) {
        super(string);
    }
    
    @Override
    public void printWeak() {
        showWithParen();
    }
    
    @Override
    public void printStrong() {
        showWithAster();
    }
    
}
```

되게 간단하지만 상속이기 때문에 사용성이 그닥 좋지는 않은것 같다.

> PrintBanner.java

```java
import structural.adapter.Banner;

public class PrintBanner implements Print {

    private Banner banner;

    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }

}
```

이렇게 하면 다른 어댑터도 갈아끼울 수 있는 형식이 되어 편리할 것이다.

> Main.java

```java
public class Main {

    public static void main(String[] args) {
        Print print = new PrintBanner("example");

        print.printWeak();
        print.printStrong();
    }
}
```

이렇게 해서 어댑터 패턴을 알아보았다.