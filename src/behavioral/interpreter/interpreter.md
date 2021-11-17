# 인터프리터 패턴

문법 규칙을 클래스화 한 패턴이다.

그 규칙으로 문법적 언어를 해석하는 패턴

## 장점

문법의 추가 및 수정, 구현이 쉬워진다.

## 단점

복잡한 문법의 경우 유지 관리가 어렵다.


## 클래스 다이어그램

![image](https://user-images.githubusercontent.com/74235102/142089335-148ccd9a-cbe5-4bba-b981-0c5d9dddedb7.png)

## 예제

진수를 변환하려는 문장을 정의하려고 한다.

수식은

`(변환하려는 수) 의 n진수` 라고 정의 를 한다.

일단 2진수, 16진수를 변환할 수 있게 해주는 컨텍스트 한개를 만들어준다.

기능을 나란히 구현해둔 뒤에 

> InterpreterContext.java

```java
public class InterpreterContext {

    public String getBinaryFormat(int number) {
        return Integer.toBinaryString(number);
    }

    public String getHexadecimalFormat(int number) {
        return Integer.toHexString(number);
    }

}
```

> Expression.java

```java
public interface Expression {

    String interpret(InterpreterContext interpreterContext);

}
```

> BinaryExpression.java

```java
public class BinaryExpression implements Expression {

    private final int number;

    public BinaryExpression(final int number) {
        this.number = number;
    }

    @Override
    public String interpret(final InterpreterContext interpreterContext) {
        return interpreterContext.getBinaryFormat(number);
    }

}
```

> HexExpression.java

```java
public class HexExpression implements Expression {

    private final int number;

    public HexExpression(final int number) {
        this.number = number;
    }

    @Override
    public String interpret(final InterpreterContext interpreterContext) {
        return interpreterContext.getHexadecimalFormat(number);
    }
}
```
> Interpreter.java

```java
public class Interpreter {

    public final InterpreterContext interpreterContext;

    public Interpreter(final InterpreterContext interpreterContext) {
        this.interpreterContext = interpreterContext;
    }

    public String interpret(String str) {
        int number = Integer.parseInt(str.substring(0, str.indexOf(" ")));
        Expression expression;
        if (str.contains("16진수")) {
            expression = new HexExpression(number);
        } else if (str.contains("2진수")) {
            expression = new BinaryExpression(number);
        } else {
            return str;
        }

        return expression.interpret(interpreterContext);
    }

}
```

> Main.java

```java
public class Main {

    public static void main(String[] args) {
        String str1 = "6 의 2진수";
        String str2 = "24 의 16진수";

        Interpreter interpreter = new Interpreter(new InterpreterContext());
        System.out.println(str1 + " = " + interpreter.interpret(str1));
        System.out.println(str2 + " = " + interpreter.interpret(str2));
    }

}
```

`Interpreter` 객체의 `interpret` 메소드 안에 분기문을 다시 전략패턴으로 리팩토링을 해서

if문을 제거하는 방법을 고려하는 것도 좋은 방법이라고 생각한다.

