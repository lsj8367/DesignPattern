package templatemethod;

public class SuperLevel extends PlayerLevel{
    @Override
    public void run() {
        System.out.println("가장 빨리 달림");
    }

    @Override
    public void jump() {
        System.out.println("가장 높은 점프");
    }

    @Override
    public void turn() {
        System.out.println("반대방향 turn");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("고급 레벨");
    }
}
