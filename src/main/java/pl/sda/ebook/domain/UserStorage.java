package pl.sda.ebook.domain;

import pl.sda.ebook.exception.UserAlreadyExistExceptions;

import java.util.HashMap;

public class UserStorage {

    HashMap<String, User> userDataSt = new HashMap<>();

    public void add(User user) throws UserAlreadyExistExceptions {
        if(loginPresent(user.getLogin())) throw new UserAlreadyExistExceptions("User already exist in storage");
        else userDataSt.put(user.getLogin(), user);
    }

    public boolean loginPresent(String username) {
        return userDataSt.containsKey(username);
    }
}

