package strategy.example;

public class Main {
    public static void main(String[] args) {
        Ainterface ainterface = new AinterfaceImpl();

        //구현체인 ainterfaceimpl 기능을 사용할수 있는 통로
        ainterface.funcA();

        AObj aObj = new AObj();
        aObj.funcAA();
    }
}
