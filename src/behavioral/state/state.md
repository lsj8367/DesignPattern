# 상태 패턴

상태 패턴은 클래스가 어떤 상태에 따라서 메소드 이름은 같지만

그 기능이 바뀐다.

최근 이 패턴으로 [연체된 유저에 대한 벌금 적용](https://github.com/lsj8367/Project/pull/30/commits/721002fcb4bccf269f292b65a1be1eae04b9a86e) 으로 패턴을 적용시켜 보았다.

그래도 나는 문제점이 있다고 생각한건

또 상태마다의 클래스가 점점 늘어야 한다는 것이 리스크 일줄 알고 저렇게만 구현을 해줬었는데 아니었다.

메소드 하나로 연체기간별 가격만 책정을 해주는 계산식인데 이거를 하려다 보니

좀 더 생각해봐야되는게 되어버렸다.

한번 더 다시 구현해봐야겠다는 생각이 든다.

그래서 이 패키지 안에 구성을 먼저 진행해보겠다.

## 클래스 다이어그램

![image](https://user-images.githubusercontent.com/74235102/135583564-c2215854-77d0-4ee9-a2de-aab009f31527.png)

State에서 설계된 메소드를 콘크리트 클래스에서 각자의 역할들을 하는 메소드로 정의해두고

사용하면 되겠다.

**상태가 추가되면 클래스를 추가해주면 된다❗❗❗**

일단 연체 기간에 의존적이라서 팩토리 클래스를 추가해줘야 된다.

> DelayFactory.java

```java
public class DelayFactory {

    public DelayState make(int delayDays) {
        if (delayDays < 3) {
            return DelayLessThan3Days.of(delayDays);
        }

        if (delayDays < 6) {
            return DelayLessThan6Days.of(delayDays);
        }

        if (delayDays < 10) {
            return DelayLessThan10Days.of(delayDays);
        }

        return DelayLessThan14Days.of(delayDays);
    }
}
```

> DelayState.java

```java
public interface DelayState {
    int delPointCalculate(int price);
}
```

> DelayLessThan3Days.java

```java
public class DelayLessThan3Days implements DelayState {

    private final int delayDays;

    private DelayLessThan3Days(int delayDays) {
        this.delayDays = delayDays;
    }

    public static DelayLessThan3Days of(int delayDays) {
        if (delayDays < 0) {
            throw new DelayLessThanZeroException("연체 기간이 0보다 작을 수 없습니다.");
        }
        return new DelayLessThan3Days(delayDays);
    }

    @Override
    public int delPointCalculate(int price) {
        return Integer.parseInt(String.valueOf(Math.round(price * 0.05)));
    }
}
```

> DelayLessThan6Days.java

```java
public class DelayLessThan6Days implements DelayState {

    private final int delayDays;

    private DelayLessThan6Days(int delayDays) {
        this.delayDays = delayDays;
    }

    public static DelayLessThan6Days of(int delayDays) {
        if (delayDays < 0) {
            throw new DelayLessThanZeroException("연체 기간이 0보다 작을 수 없습니다.");
        }
        return new DelayLessThan6Days(delayDays);
    }

    @Override
    public int delPointCalculate(int price) {
        return Integer.parseInt(String.valueOf(Math.round(price * 0.1)));
    }
}
```

> DelayLessThan10Days.java

```java
public class DelayLessThan10Days implements DelayState {

    private final int delayDays;

    private DelayLessThan10Days(int delayDays) {
        this.delayDays = delayDays;
    }

    public static DelayLessThan10Days of(int delayDays) {
        if (delayDays < 0) {
            throw new DelayLessThanZeroException("연체 기간이 0보다 작을 수 없습니다.");
        }
        return new DelayLessThan10Days(delayDays);
    }

    @Override
    public int delPointCalculate(int price) {
        return Integer.parseInt(String.valueOf(Math.round(price * 0.15)));
    }
}
```

> DelayLessThan14Days.java

```java
public class DelayLessThan14Days implements DelayState {

    private final int delayDays;

    private DelayLessThan14Days(int delayDays) {
        this.delayDays = delayDays;
    }

    public static DelayLessThan14Days of(int delayDays) {
        if (delayDays < 0) {
            throw new DelayLessThanZeroException("연체 기간이 0보다 작을 수 없습니다.");
        }
        return new DelayLessThan14Days(delayDays);
    }

    @Override
    public int delPointCalculate(int price) {
        return Integer.parseInt(String.valueOf(Math.round(price * 0.2)));
    }
}
```

> DelayLessThanZeroException.java

```java
public class DelayLessThanZeroException extends IllegalArgumentException {

    public DelayLessThanZeroException(String message) {
        super(message);
    }
}
```

저 if문은 어떻게 해서 없앨 수 있을지 또 고민해보면서 이번 정리는 마친다.