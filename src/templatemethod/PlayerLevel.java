package templatemethod;

public abstract class PlayerLevel {
    public abstract void run();
    public abstract void jump();
    public abstract void turn();
    public abstract void showLevelMessage();

    private void fly() {
        // 훅메소드 : 부가적인 기능을 추가할 수 있지만
        // abstract 추상메소드와는 달리 경우에 따라만 재정의 하여 사용한다.
    }

    final public void go(int count) { //템플릿메서드 정의 기능은 주로 final 바꾸면 안되니까
        run();
        for (int i = 0; i < count; i++) {
            jump();
        }
        turn();
        fly();
    }


}
