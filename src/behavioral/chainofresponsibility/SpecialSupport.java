package behavioral.chainofresponsibility;

public class SpecialSupport extends Support {

    private int number;

    public SpecialSupport(final String name, final int number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(final Trouble trouble) {
        if (trouble.getNumber() == number) {
            return true;
        }

        return false;
    }
}
