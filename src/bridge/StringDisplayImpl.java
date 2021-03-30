package bridge;

import java.util.stream.IntStream;

public class StringDisplayImpl extends DisplayImpl{

    private final String string;
    private final int width;

    public StringDisplayImpl(String string){
        this.string = string;
        this.width = string.getBytes().length;
    }

    @Override
    public void rawOpen() {
        printLine();
    }


    @Override
    public void rawPrint() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void rawClose() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        //for문 stream형식 한번 sout 실행될때 '-' 출력
        IntStream.range(0, width).mapToObj(i -> "-").forEach(System.out::print);
        System.out.println("+");
    }
}
