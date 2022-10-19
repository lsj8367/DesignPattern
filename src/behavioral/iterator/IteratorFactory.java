package behavioral.iterator;

public class IteratorFactory extends Factory {

    private static IteratorFactory iteratorFactory = new IteratorFactory();

    private IteratorFactory() {

    }

    public static IteratorFactory getInstance() {
        if (iteratorFactory == null) {
            iteratorFactory = new IteratorFactory();
        }
        return iteratorFactory;
    }

    @Override
    protected Iterator createProduct(Aggregate bookShelf, int type) {
        if (type == Constant.FORWARD.getNumber()) {
            return new BookShelfIterator(bookShelf);
        } else if (type == Constant.REVERSE.getNumber()) {
            return new ReverseIterator(bookShelf);
        } else {
            return null;
        }

    }

}
