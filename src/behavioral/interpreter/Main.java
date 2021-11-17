package behavioral.interpreter;

public class Main {

    public static void main(String[] args) {
        String str1 = "6 의 2진수";
        String str2 = "24 의 16진수";

        Interpreter interpreter = new Interpreter(new InterpreterContext());
        System.out.println(str1 + " = " + interpreter.interpret(str1));
        System.out.println(str2 + " = " + interpreter.interpret(str2));
    }

}
