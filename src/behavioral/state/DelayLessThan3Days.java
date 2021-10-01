package behavioral.state;

import behavioral.state.exception.DelayLessThanZeroException;

public class DelayLessThan3Days implements DelayState {

    private final int delayDays;

    private DelayLessThan3Days(int delayDays) {
        this.delayDays = delayDays;
    }

    public static DelayLessThan3Days of(int delayDays) {
        if (delayDays < 0) {
            throw new DelayLessThanZeroException("연체 기간이 0보다 작을 수 없습니다.");
        }
        return new DelayLessThan3Days(delayDays);
    }

    @Override
    public int delPointCalculate(int price) {
        return Integer.parseInt(String.valueOf(Math.round(price * 0.05)));
    }
}
