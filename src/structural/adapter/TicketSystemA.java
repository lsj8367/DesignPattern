package structural.adapter;

public class TicketSystemA implements TicketA{

    @Override
    public void choice(int token) {
        System.out.println("선택된 식권 타입은 " + token + "입니다.");
    }

    @Override
    public void print() {
        System.out.println("식권을 출력합니다.");
    }

    @Override
    public void buy() {
        System.out.println("식권을 구매합니다.");
    }
}
