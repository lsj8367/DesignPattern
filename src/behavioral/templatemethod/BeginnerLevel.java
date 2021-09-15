package behavioral.templatemethod;

public class BeginnerLevel extends PlayerLevel{
    @Override
    public void run() {
        System.out.println("천천히 달린다.");
    }

    @Override
    public void jump() {
        System.out.println("Jump 할줄 모름");
    }

    @Override
    public void turn() {
        System.out.println("turn 할줄 모름");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("비기너 레벨");
    }
}
