package abstractFactory.domain.userinfo.dao;

import abstractFactory.domain.product.Product;
import abstractFactory.domain.userinfo.UserInfo;

public interface UserInfoDao {
    void insertUserInfo(UserInfo product);
    void updateUserInfo(UserInfo product);
    void deleteUserInfo(UserInfo product);
}
