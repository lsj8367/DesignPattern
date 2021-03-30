package factory;

public class FactoryPattern {
    public static void main(String[] args) {
        FigureFactory factory = new FigureFactory();

        Figure fig1 = factory.getFigure("CIRCLE");

        //Circle의 draw 호출
        fig1.draw();

        Figure fig2 = factory.getFigure("RECTANGLE");

        //RECTANGEL의 draw 호출
        fig2.draw();

        Figure fig3 = factory.getFigure("SQUARE");

        //SQUARE의 draw 호출
        fig3.draw();
    }
}
