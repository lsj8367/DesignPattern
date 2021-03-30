package builder;

public class UserBuilder {
    private int id;
    private String name;
    private String address;

    public UserBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public User build() {
        return new User(id, name, address);
    }
}
