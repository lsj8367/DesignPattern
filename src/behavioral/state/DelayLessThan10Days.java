package behavioral.state;

import behavioral.state.exception.DelayLessThanZeroException;

public class DelayLessThan10Days implements DelayState {

    private final int delayDays;

    private DelayLessThan10Days(int delayDays) {
        this.delayDays = delayDays;
    }

    public static DelayLessThan10Days of(int delayDays) {
        if (delayDays < 0) {
            throw new DelayLessThanZeroException("연체 기간이 0보다 작을 수 없습니다.");
        }
        return new DelayLessThan10Days(delayDays);
    }

    @Override
    public int delPointCalculate(int price) {
        return Integer.parseInt(String.valueOf(Math.round(price * 0.15)));
    }
}
