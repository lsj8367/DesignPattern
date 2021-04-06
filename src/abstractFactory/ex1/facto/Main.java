package abstractFactory.ex1.facto;

import abstractFactory.ex1.Sam.SamFactory;

public class Main {
    public static void main(String[] args) {
        BikeFactory factory = new SamFactory();
        Body body = factory.createBody();
        Wheel wheel = factory.createWheel();

        System.out.println(body.getClass());
        System.out.println(wheel.getClass());

        //자전거를 생성하려면 자전거 공장이 필요함
        // 관련있는것들을 한 패키지로 묶어 생성해줄수 있음.
    }
}
