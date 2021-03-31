package templateMethod;

public class DefaultGameConnection extends AbstGameConnectHelper{

    @Override
    protected String doSecurity(String info) {
        System.out.println("강화 알고리즘을 이용한 디코드");
        return info;
    }

    @Override
    protected boolean authentication(String id, String password) {
        System.out.println("계정 확인하는 과정");
        return true;
    }

    @Override
    protected int authorization(String userName) {
        System.out.println("권한 확인");
        //서버에서 유저이름 유저의 나이를 알 수 있다.
        //나이 확인 후 시간 확인하여 청소년이며 10시가 지났다면
        //권한 없는것으로 한다.

        return 0;
    }

    @Override
    protected String connection(String info) {
        System.out.println("마지막의 접속 단계");
        return info;
    }
}
