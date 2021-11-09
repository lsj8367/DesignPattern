package behavioral.chainofresponsibility;

public class OddSupport extends Support {

    public OddSupport(final String name) {
        super(name);
    }

    @Override
    protected boolean resolve(final Trouble trouble) {
        if (trouble.getNumber() % 2 == 1) {
            return true;
        }

        return false;
    }
}
