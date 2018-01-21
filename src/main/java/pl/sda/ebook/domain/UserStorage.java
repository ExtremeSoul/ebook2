package pl.sda.ebook.domain;

import java.util.HashMap;

public class UserStorage {

    HashMap<String, User> userDataSt = new HashMap<>();

    public void add(User user) {
        userDataSt.put(user.getLogin(), user);
    }

    public boolean present(String username) {
        return userDataSt.containsKey(username);
    }
}

