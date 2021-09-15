package strategy.scheduler;

public class LeastJob implements Scheduler {

    @Override
    public void getNextCall() {
        System.out.println("상담 전화 순서대로 대기열에서 가져옴");
    }

    @Override
    public void sendCallToAgent() {
        System.out.println("현재 상담업무 없거나 상담대기가 가장 작은 상담원에게 할당");
    }
}
