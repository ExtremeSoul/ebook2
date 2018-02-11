package pl.sda.ebook.domain;

import java.io.FileNotFoundException;

public class UserStorageFactory {

    public UserStorage createFileUserStorage() {
        UserWriter userWriter = new UserWriter();
        UserStorage userStorage = new FileUserStorage(userWriter);
        try {
            userStorage.downloadUsersDatabase();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return userStorage;
    }
}
