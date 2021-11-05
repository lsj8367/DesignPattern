package behavioral.visitor;

public interface ComputerPartVisitor {

    void visit(Computer computer);
    void visit(Mouse mouse);
    void visit(KeyBoard keyBoard);
    void visit(Monitor monitor);

}
