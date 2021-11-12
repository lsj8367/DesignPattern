package structural.proxy;

public class RealSubject implements Subject {

    private final String behavior;

    public RealSubject(final String behavior) {
        this.behavior = behavior;
    }

    @Override
    public void doAction() {
        System.out.println(behavior + " Action of RealSubject");
    }
}
