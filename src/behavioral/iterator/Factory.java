package behavioral.iterator;

public abstract class Factory {
    public final Iterator create(Aggregate aggregate, int type) {
        Iterator p = createProduct(aggregate, type);
        return p;
    }

    protected abstract Iterator createProduct(Aggregate aggregate, int type);
}
