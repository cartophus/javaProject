package entities;

import java.io.Serializable;

public class Login implements Serializable{

    private String role;
    private String username;
    private String password;

    public Login(){}

    public Login(String role, String username, String password) {
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "role='" + role + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
