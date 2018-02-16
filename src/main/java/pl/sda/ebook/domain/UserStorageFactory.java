package pl.sda.ebook.domain;

public class UserStorageFactory {

    public UserStorage createJSONFileUserStorage() {
        UserStorage userStorage = new JSONFileUserStorage();
        return userStorage;
    }
}
