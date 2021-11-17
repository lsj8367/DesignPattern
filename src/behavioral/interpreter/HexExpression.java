package behavioral.interpreter;

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
