package structural.proxy;

public class Main {

    public static void main(String[] args) {
        Subject subject = new Proxy("run!!!");

        subject.doAction();
    }

}
