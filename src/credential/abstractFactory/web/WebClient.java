package credential.abstractFactory.web;

import credential.abstractFactory.domain.product.Product;
import credential.abstractFactory.domain.product.dao.ProductDao;
import credential.abstractFactory.domain.userinfo.UserInfo;
import credential.abstractFactory.domain.userinfo.dao.UserInfoDao;
import credential.abstractFactory.factory.DaoFactory;
import credential.abstractFactory.factory.MysqlDaoFactory;
import credential.abstractFactory.factory.OracleDaoFactory;

import java.io.FileInputStream;
import java.util.Properties;

public class WebClient {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("db.properties");

        Properties properties = new Properties();
        properties.load(fileInputStream);

        String dbType = properties.getProperty("DBTYPE");

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("123");
        userInfo.setPassword("!@#");
        userInfo.setUserName("테스트");

        Product product = new Product();
        product.setProductId("4214");
        product.setProductName("TV");

        DaoFactory daoFactory = null;

        if (dbType.equals("MYSQL")) {
            daoFactory = new MysqlDaoFactory();
        } else if (dbType.equals("ORACLE")) {
            daoFactory = new OracleDaoFactory();
        } else {
            System.out.println("error");
        }

        UserInfoDao userInfoDao = daoFactory.createUserInfoDao();
        System.out.println("userinfo Transaction");
        userInfoDao.insertUserInfo(userInfo);
        userInfoDao.updateUserInfo(userInfo);
        userInfoDao.deleteUserInfo(userInfo);

        ProductDao productDao = daoFactory.createProductDao();

        System.out.println("product transaction");
        productDao.insertProduct(product);
        productDao.updateProduct(product);
        productDao.deleteProduct(product);
    }
}
