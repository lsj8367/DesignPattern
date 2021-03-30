package factory;

public class FigureFactory {
    public Figure getFigure(String figureType){
        if(figureType == null){
            return null;
        }
        if(figureType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if(figureType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if(figureType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
