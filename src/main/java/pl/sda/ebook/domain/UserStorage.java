package pl.sda.ebook.domain;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UserStorage {
    void downloadUsersDatabase() throws FileNotFoundException;

    void add(User user) throws UserAlreadyExistExceptions, IOException;

    boolean loginPresent(String username) throws FileNotFoundException;

    boolean passwordPresent(String login, String password) throws FileNotFoundException;
}
