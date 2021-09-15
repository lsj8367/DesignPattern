package behavioral.strategy;

import java.io.IOException;
import behavioral.strategy.scheduler.LeastJob;
import behavioral.strategy.scheduler.PriorityAllocation;
import behavioral.strategy.scheduler.RoundRobin;
import behavioral.strategy.scheduler.Scheduler;

public class SchedulerTest {

    public static void main(String[] args) throws IOException {
        System.out.println("상담 방식 선택");
        System.out.println("R : 한명씩 차례로 할당");
        System.out.println("L : 쉬고 있거나 대기가 가장 적은 상담원에게 할당");
        System.out.println("P : 우선순위가 높은 고객 먼저 할당");
        System.out.println("A : 상담원이 상담 가져가기");

        int ch = System.in.read();

        Scheduler scheduler = null;

        if(ch == 'r' || ch == 'R') {
            scheduler = new RoundRobin();
        }else if (ch == 'l' || ch == 'L') {
            scheduler = new LeastJob();
        }else if (ch == 'p' || ch == 'P') {
            scheduler = new PriorityAllocation();
        }else {
            System.out.println("not support");
        }

        scheduler.getNextCall();
        scheduler.sendCallToAgent();
    }
}
