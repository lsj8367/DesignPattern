package behavioral.command;

public class GigaGenie {

    private Command command;

    public void talk() {
        command.execute();
    }

    public void setCommand(final Command command) {
        this.command = command;
    }
}
