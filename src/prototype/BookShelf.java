package prototype;

import java.util.ArrayList;
import java.util.List;

public class BookShelf implements Cloneable { //이 객체가 복제해도 된다는것을 명시해줌
    private List<Book> shelf;

    public BookShelf() {
        this.shelf = new ArrayList<>();
    }

    public void addBook(Book book) {
        shelf.add(book);
    }

    public List<Book> getShelf() {
        return shelf;
    }

    public void setShelf(final List<Book> shelf) {
        this.shelf = shelf;
    }

    public String toString() {
        return shelf.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        prototype.BookShelf clone = new prototype.BookShelf();

        for (Book book : shelf) {
            clone.addBook(new Book(book.getAuthor(), book.getTitle()));
        }

        return clone;
    }
}
