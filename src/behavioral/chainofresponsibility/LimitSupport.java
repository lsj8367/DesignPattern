package behavioral.chainofresponsibility;

public class LimitSupport extends Support {

    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(final Trouble trouble) {
        if (trouble.getNumber() < limit) {
            return true;
        }

        return false;
    }
}
