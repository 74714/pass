package Model;

public class User {
    private String username;
    private String password;
    private String hexPassword;

    public User(String username, String password, String hexPassword) {
        this.username = username;
        this.password = password;
        this.hexPassword = hexPassword;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getHexPassword() {
        return hexPassword;
    }
}
