package behavioral.interpreter;

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
