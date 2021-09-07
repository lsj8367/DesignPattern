package abstractFactory.domain.userinfo.dao.oracle;

import abstractFactory.domain.userinfo.UserInfo;
import abstractFactory.domain.userinfo.dao.UserInfoDao;

public class UserInfoOracleDao implements UserInfoDao {
    @Override
    public void insertUserInfo(final UserInfo userInfo) {
        System.out.println("oracle insert " + userInfo.getUserId());
    }

    @Override
    public void updateUserInfo(final UserInfo userInfo) {
        System.out.println("oracle update " + userInfo.getUserId());

    }

    @Override
    public void deleteUserInfo(final UserInfo userInfo) {
        System.out.println("oracle delete " + userInfo.getUserId());

    }
}
