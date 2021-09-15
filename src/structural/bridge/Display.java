package structural.bridge;

//기능 클래스 계층
public class Display {
    //이 필드가 두 클래스 계층의 다리역할을 한다.
    private DisplayImpl impl;

    public Display(DisplayImpl impl){
        this.impl = impl;
    }

    public void open(){
        impl.rawOpen();
    }

    public void print(){
        impl.rawPrint();
    }

    public void close(){
        impl.rawClose();
    }

    public final void display(){
        open();
        print();
        close();
    }

}
