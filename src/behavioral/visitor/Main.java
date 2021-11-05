package behavioral.visitor;

public class Main {

    public static void main(String[] args) {
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());

        ComputerPart mouse = new Mouse();
        mouse.accept(new ComputerPartDisplayVisitor());

        ComputerPart monitor = new Monitor();
        monitor.accept(new ComputerPartDisplayVisitor());

        ComputerPart keyBoard = new KeyBoard();
        keyBoard.accept(new ComputerPartDisplayVisitor());
    }

}
