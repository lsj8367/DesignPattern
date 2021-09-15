package credential.abstractFactory.domain.userinfo.dao;

import credential.abstractFactory.domain.userinfo.UserInfo;

public interface UserInfoDao {
    void insertUserInfo(UserInfo product);
    void updateUserInfo(UserInfo product);
    void deleteUserInfo(UserInfo product);
}
