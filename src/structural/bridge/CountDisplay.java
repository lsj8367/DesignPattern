package structural.bridge;

import java.util.stream.IntStream;

//기능클래스
public class CountDisplay extends Display{

    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(int times){
        open();
        IntStream.range(0, times).forEach(i -> print()); //times 회수만큼 반복하여 표시
        close();
    }
}
