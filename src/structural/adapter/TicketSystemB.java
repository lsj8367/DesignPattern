package structural.adapter;

public class TicketSystemB implements TicketB{

    @Override
    public void choice(int token) {
        System.out.println("선택된 식권 타입은 " + token + "입니다.");
    }

    @Override
    public void print() {
        System.out.println("식권을 출력합니다.");
    }

    @Override
    public void buyOnOffline() {
        System.out.println("오프라인으로 구매합니다.");
    }

    @Override
    public void buyOnOnline() {
        System.out.println("온라인으로 구매합니다.");
    }

    @Override
    public String getMenu() {
        return "메뉴정보를 가져왔습니다.";
    }
}
