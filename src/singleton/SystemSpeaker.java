package singleton;

public class SystemSpeaker {
    private static SystemSpeaker instance;
    private int volume;

    private SystemSpeaker(){
        volume = 5;
    }

    public static SystemSpeaker getInstance(){
        if(instance == null)
            instance = new SystemSpeaker();

        return instance;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
