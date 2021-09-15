package credential.abstractFactory.domain.product.dao.oracle;

import credential.abstractFactory.domain.product.Product;
import credential.abstractFactory.domain.product.dao.ProductDao;

public class ProductOracleDao implements ProductDao {
    @Override
    public void insertProduct(final Product product) {
        System.out.println("oracle insert" + product.getProductId());
    }

    @Override
    public void updateProduct(final Product product) {
        System.out.println("oracle update" + product.getProductId());

    }

    @Override
    public void deleteProduct(final Product product) {
        System.out.println("oracle delete" + product.getProductId());

    }
}
