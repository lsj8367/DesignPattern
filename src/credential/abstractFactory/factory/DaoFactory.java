package credential.abstractFactory.factory;

import credential.abstractFactory.domain.product.dao.ProductDao;
import credential.abstractFactory.domain.userinfo.dao.UserInfoDao;

public interface DaoFactory {
    public UserInfoDao createUserInfoDao();
    public ProductDao createProductDao();
}
