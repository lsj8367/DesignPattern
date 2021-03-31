package strategy.example;

public class AObj {

    Ainterface ainterface;

    public AObj(){
        ainterface = new AinterfaceImpl();
    }

    public void funcAA(){

        //위임 - 기능을 구현할때 그 책임을 다른 객체의 기능을 빌려 사용하는것.
        ainterface.funcA();
        ainterface.funcA();

//        System.out.println("AAA");
//        System.out.println("AAA");

        //~ 기능들이필요하다. 추가_+++
    }
}
