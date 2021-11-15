package behavioral.command;

public class Client {

    public static void main(String[] args) {
        TvCommand tvCommand = new TvCommand(new Tv());
        GigaGenie gigaGenie = new GigaGenie();
        gigaGenie.setCommand(tvCommand);
        gigaGenie.talk();

        LampCommand lampCommand = new LampCommand(new Lamp());
        gigaGenie.setCommand(lampCommand);
        gigaGenie.talk();

    }

}
