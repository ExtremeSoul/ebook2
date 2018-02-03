package pl.sda.ebook.domain;

public class User {

    private String login;



    private String psw;

    public User(String login, String psw) {
        this.login = login;
        this.psw = psw;
    }

    public String getLogin() {
        return login;
    }
    public String getPsw() {
        return psw;
    }

    public boolean hasTheSamePasswordAs(String password) {
        return this.psw.equals(password);
    }
}
