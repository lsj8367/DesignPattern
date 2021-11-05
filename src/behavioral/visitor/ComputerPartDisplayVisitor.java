package behavioral.visitor;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

    @Override
    public void visit(Computer computer) {
        System.out.println("Computer Display : " + computer);
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Mouse Display : " + mouse);
    }

    @Override
    public void visit(KeyBoard keyBoard) {
        System.out.println("KeyBoard Display : " + keyBoard);
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Monitor Display : " + monitor);
    }
}
