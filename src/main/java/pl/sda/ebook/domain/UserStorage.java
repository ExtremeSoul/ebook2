package pl.sda.ebook.domain;

import java.util.HashMap;

public interface UserStorage {
    void add(User user);

    boolean existUser(String login, String password);

    boolean existLogin(String login);

    HashMap downloadUsersDatabase();

}
