package behavioral.iterator;

public abstract class Factory {
    public final Iterator create(Aggregate aggregate, int type) {
        return createProduct(aggregate, type);
    }

    protected abstract Iterator createProduct(Aggregate aggregate, int type);
}
