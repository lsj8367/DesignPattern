package behavioral.state;

public class DelayFactory {

    public DelayState make(int delayDays) {
        if (delayDays < 3) {
            return DelayLessThan3Days.of(delayDays);
        }

        if (delayDays < 6) {
            return DelayLessThan6Days.of(delayDays);
        }

        if (delayDays < 10) {
            return DelayLessThan10Days.of(delayDays);
        }

        return DelayLessThan14Days.of(delayDays);
    }
}
