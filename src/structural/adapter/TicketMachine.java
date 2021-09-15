package structural.adapter;

public class TicketMachine {
    public static void main(String[] args) {
//        TicketA ticketA = new TicketSystemA();
//        ticketA.choice(1);
//        ticketA.buy();
//        ticketA.print();
//
//        System.out.println("----------------------");
//
//        TicketB ticketB = new TicketSystemB();
//        ticketB.choice(1);
//        ticketB.buyOnOffline();
//        ticketB.buyOnOnline();
//        ticketB.print();
//        System.out.println(ticketB.getMenu());
        TicketB ticketB = new TicketAdapter(new TicketSystemA());
        ticketB.choice(1);
        ticketB.buyOnOffline();
        ticketB.print();
        try{
            System.out.println(ticketB.getMenu());
        }catch (UnsupportedOperationException e){
            System.out.println("이 서비스는 다른 시스템에서 제공되는 기능입니다.");
        }
    }
}
