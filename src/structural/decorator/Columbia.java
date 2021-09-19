package structural.decorator;

public class Columbia extends Coffee {
    @Override
    public void brew() {
        System.out.print("콜롬비아 에스프레소");
    }
}
