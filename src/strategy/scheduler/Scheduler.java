package strategy.scheduler;

public interface Scheduler {
    void getNextCall();
    void sendCallToAgent();
}
