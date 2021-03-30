package builder;

public class main {
    public static void main(String[] args) {
        UserBuilder builder = new UserBuilder();

        User user = builder
                .setId(1)
                .setName("홍길동")
                .setAddress("서울")
                .build();

        System.out.println(user.getId() + " " + user.getName() + " " + user.getAddress());
    }
}
