package pl.sda.ebook.domain;

public abstract class Person {

    String login;
    String password;

    public Person(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
