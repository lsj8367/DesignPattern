package templateMethod;

public abstract class AbstGameConnectHelper {

    //알고리즘의 단계라서 외부에 노출되면 안되기 때문에 protected 선언

    //보안단계
    abstract protected String doSecurity(String info);

    //인증단계
    abstract protected boolean authentication(String id, String password);

    //권한단계
    abstract protected int authorization(String userName);

    //접속단계
    abstract protected String connection(String info);


    //템플릿 메소드
    public String requestConnection(String encodeInfo){

        // 보안작업 -> 암호화 문자열
        String decodedInfo = doSecurity(encodeInfo);
        //반환값으로 id, pwd 받음(할당)

        String id = "aa";
        String pwd = "bbb";

        if(!authentication(id, pwd)){
            throw new Error("아이디, 패스워드 불일치");
        }

        String userName = "userName";
        int i = authorization(userName);

        switch (i){
            case -1:
                throw new Error("권한이 없습니다");

            case 0: //게임 매니저

                break;
            case 1: //유료 회원

                break;
            case 2: //무료 회원

                break;
            case 3: //권한 없음

                break;
            default: //기타 상황

                break;
        }

        return connection(decodedInfo);
    }
}
