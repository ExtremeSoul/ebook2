package pl.sda.ebook.domain;

import java.util.HashMap;

public class UserStorage {

    HashMap<String, String> userDataSt = new HashMap<String, String>();

    public void add(String login, String password) {
        userDataSt.put(login,password);
    }

    public boolean present(String username) {
        return userDataSt.containsKey(username);
    }
}

