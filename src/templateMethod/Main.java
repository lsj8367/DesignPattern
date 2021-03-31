package templateMethod;

public class Main {
    public static void main(String[] args) {
        AbstGameConnectHelper helper = new DefaultGameConnection();
        helper.requestConnection("아이디 암호 접속 정보");
    }
}
