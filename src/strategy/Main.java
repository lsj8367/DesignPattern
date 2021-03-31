package strategy;

public class Main {
    public static void main(String[] args) {
        GameCharacter character = new GameCharacter();

        character.attack();

        character.setWeapon(new Knife()); //칼
        character.attack();

        character.setWeapon(new Sword()); //검
        character.attack();

        character.setWeapon(new Ax()); //도끼
        character.attack();
    }
}
