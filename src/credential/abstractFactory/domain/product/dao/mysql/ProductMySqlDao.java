package credential.abstractFactory.domain.product.dao.mysql;

import credential.abstractFactory.domain.product.Product;
import credential.abstractFactory.domain.product.dao.ProductDao;

public class ProductMySqlDao implements ProductDao {
    @Override
    public void insertProduct(final Product product) {
        System.out.println("mysqlDao insert" + product.getProductId());
    }

    @Override
    public void updateProduct(final Product product) {
        System.out.println("mysqlDao update" + product.getProductId());

    }

    @Override
    public void deleteProduct(final Product product) {
        System.out.println("mysqlDao delete" + product.getProductId());

    }
}
