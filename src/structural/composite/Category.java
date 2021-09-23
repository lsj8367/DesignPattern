package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Category extends ProductCategory {

    List<ProductCategory> list;

    public Category(int id, String name, int price) {
        super(id, name, price);
        list = new ArrayList<>();
    }

    @Override
    public void addProductCategory(ProductCategory productCategory) {
        list.add(productCategory);
    }

    @Override
    public void removeProductCategory(ProductCategory productCategory) {
        for (ProductCategory category : list) {
            if(category.getId() == productCategory.getId()) {
                list.remove(category);
                return;
            }
        }

        System.out.println("상품이 없습니다.");
    }

    @Override
    public int getCount() {
        int count = 0;
        for (ProductCategory productCategory : list) {
            count += productCategory.getCount();
        }

        return count;
    }

    @Override
    public int getPrice() {
        int price = 0;
        for (ProductCategory productCategory : list) {
            price += productCategory.getPrice();
        }

        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

}
