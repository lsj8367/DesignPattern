package prototype;

import java.util.ArrayList;
import java.util.List;


public class ProtoTypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        BookShelf bookShelf = new BookShelf();

        bookShelf.addBook(new Book("마틴 파울러", "리팩토링"));
        bookShelf.addBook(new Book("김영한", "자바 ORM 표준 JPA 프로그래밍"));
        bookShelf.addBook(new Book("조슈아 블로크", "이펙티브 자바"));

        System.out.println(bookShelf);

        BookShelf another = (BookShelf) bookShelf.clone();

        System.out.println(another);

        bookShelf.getShelf().get(0).setAuthor("marin pauler");
        bookShelf.getShelf().get(0).setTitle("refactoring");

        // 얕은복사가 일어남
        System.out.println(bookShelf);
        System.out.println(another);
    }
}
