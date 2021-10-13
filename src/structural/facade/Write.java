package structural.facade;

public class Write {

    private final String message;

    public Write(String message) {
        this.message = message;
    }

    public void write() {
        System.out.println("쓰기 내용 : " + message);
    }
}
