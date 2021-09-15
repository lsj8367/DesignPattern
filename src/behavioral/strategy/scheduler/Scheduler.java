package behavioral.strategy.scheduler;

public interface Scheduler {
    void getNextCall();
    void sendCallToAgent();
}
