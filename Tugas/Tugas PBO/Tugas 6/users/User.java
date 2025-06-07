package users;

public abstract class User {
    protected String nama;
    protected String password;

    public User(String nama, String password) {
        this.nama = nama;
        this.password = password;
    }

    public String getNama() { return nama; }
    public String getPassword() { return password; }
}
