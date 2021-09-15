package credential.abstractFactory.factory;

import credential.abstractFactory.domain.product.dao.ProductDao;
import credential.abstractFactory.domain.product.dao.mysql.ProductMySqlDao;
import credential.abstractFactory.domain.userinfo.dao.UserInfoDao;
import credential.abstractFactory.domain.userinfo.dao.mysql.UserInfoMysqlDao;

public class MysqlDaoFactory implements DaoFactory{
    @Override
    public UserInfoDao createUserInfoDao() {
        return new UserInfoMysqlDao();
    }

    @Override
    public ProductDao createProductDao() {
        return new ProductMySqlDao();
    }
}
