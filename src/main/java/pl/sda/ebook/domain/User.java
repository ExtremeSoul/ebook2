package pl.sda.ebook.domain;

public class User {

    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String toJSON() {
        return "{" + "login:" + login + "," +
                "password:" + password + "}";
    }

    public boolean hasTheSamePasswordAs(String password) {
        return this.password.equals(password);
    }
}