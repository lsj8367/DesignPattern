package abstractFactory.domain.userinfo.dao.mysql;

import abstractFactory.domain.userinfo.UserInfo;
import abstractFactory.domain.userinfo.dao.UserInfoDao;

public class UserInfoMysqlDao implements UserInfoDao {
    @Override
    public void insertUserInfo(final UserInfo product) {
        System.out.println("mysqldao insert" + product.getUserId());
    }

    @Override
    public void updateUserInfo(final UserInfo product) {
        System.out.println("mysqldao update" + product.getUserId());
    }

    @Override
    public void deleteUserInfo(final UserInfo product) {
        System.out.println("mysqldao delete" + product.getUserId());
    }
}
