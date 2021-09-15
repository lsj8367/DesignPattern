package credential.abstractFactory.factory;

import credential.abstractFactory.domain.product.dao.ProductDao;
import credential.abstractFactory.domain.product.dao.oracle.ProductOracleDao;
import credential.abstractFactory.domain.userinfo.dao.UserInfoDao;
import credential.abstractFactory.domain.userinfo.dao.oracle.UserInfoOracleDao;

public class OracleDaoFactory implements DaoFactory{
    @Override
    public UserInfoDao createUserInfoDao() {
        return new UserInfoOracleDao();
    }

    @Override
    public ProductDao createProductDao() {
        return new ProductOracleDao();
    }
}
