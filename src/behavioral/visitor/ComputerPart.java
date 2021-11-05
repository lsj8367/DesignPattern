package behavioral.visitor;

public interface ComputerPart {

    void accept(ComputerPartVisitor computerPartVisitor);

}
