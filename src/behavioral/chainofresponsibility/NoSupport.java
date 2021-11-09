package behavioral.chainofresponsibility;

public class NoSupport extends Support {

    public NoSupport(final String name) {
        super(name);
    }

    @Override
    protected boolean resolve(final Trouble trouble) {
        return false;
    }
}
