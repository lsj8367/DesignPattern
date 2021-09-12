package templatemethod;

public class MainBoard {
    public static void main(String[] args) {
        Player player = new Player();
        player.play(1);

        PlayerLevel playerLevel = new AdvancedLevel();
        player.upgradeLevel(playerLevel);
        player.play(2);

        playerLevel = new SuperLevel();
        player.upgradeLevel(playerLevel);
        player.play(5);
    }
}
