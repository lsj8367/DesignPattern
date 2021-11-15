package behavioral.command;

public class TvCommand implements Command {

    private final Tv tv;

    public TvCommand(final Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }
}
