package behavioral.iterator;

public enum Constant {
    FORWARD(0),
    REVERSE(1);

    private int number;

    Constant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
