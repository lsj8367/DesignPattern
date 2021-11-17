package behavioral.interpreter;

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
