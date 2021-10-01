package behavioral.state;

public class Main {

    public static void main(String[] args) {
        int delayDays = 14;
        DelayFactory delayFactory = new DelayFactory();
        DelayState delayState = delayFactory.make(delayDays);
        System.out.println(delayState.delPointCalculate(10000));
    }

}
