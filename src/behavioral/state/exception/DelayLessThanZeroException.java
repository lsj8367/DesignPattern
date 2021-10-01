package behavioral.state.exception;

public class DelayLessThanZeroException extends IllegalArgumentException {

    public DelayLessThanZeroException(String message) {
        super(message);
    }
}
