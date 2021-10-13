package structural.facade;

public class Facade {
    private final Speak speak;
    private final Write write;
    private final Read read;

    public Facade() {
        this.speak = new Speak();
        this.write = new Write("내용을 적는다");
        this.read = new Read();
    }

    public void doSomething() {
        speak.speak();
        write.write();
        read.read();
    }

}
