package adapter;

public class TicketAdapter implements TicketB{

    private TicketA ticket;

    public TicketAdapter(TicketA ticket){
        super();
        this.ticket = ticket;
    }

    @Override
    public void choice(int token) {
        ticket.choice(token);
    }

    @Override
    public void print() {
        ticket.print();
    }

    @Override
    public void buyOnOffline() {
        ticket.buy();
    }

    @Override
    public void buyOnOnline() {
        throw new UnsupportedOperationException("지원되지 않는 기능");
    }

    @Override
    public String getMenu() {
        throw new UnsupportedOperationException("지원되지 않는 기능");
    }
}
