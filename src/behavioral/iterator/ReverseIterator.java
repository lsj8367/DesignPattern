package behavioral.iterator;

public class ReverseIterator implements Iterator {

    private BookShelf bookShelf;
    private int index;

    public ReverseIterator(Aggregate bookShelf) {
        this.bookShelf = (BookShelf) bookShelf;
        this.index = bookShelf.getLength() - 1;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index--;
        return book;
    }
}
