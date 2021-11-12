package structural.proxy;

public class Proxy implements Subject {

    private final String behavior;
    private Subject subject;

    public Proxy(final String behavior) {
        this.behavior = behavior;
    }

    @Override
    public void doAction() {
        subject = new RealSubject(behavior);
        subject.doAction();
    }

}
