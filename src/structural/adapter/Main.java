package structural.adapter;

public class Main {

    public static void main(String[] args) {
        Print print = new PrintBanner2("hello");
        print.printStrong();
        print.printWeak();
    }
}
