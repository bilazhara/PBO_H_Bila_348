public class Admin {
    private final String username = "admin348";
    private final String password = "password348";

    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }
}
