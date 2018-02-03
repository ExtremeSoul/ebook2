package pl.sda.ebook.domain;

import pl.sda.ebook.exception.UserAlreadyExistExceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class UserStorage {
    public UserWriter getUserWriter() {
        return userWriter;
    }

    private UserWriter userWriter;
    HashMap<String, User> userDataSt = new HashMap<>();


    public UserStorage(UserWriter userWriter) {
        this.userWriter = userWriter;
    }


    public void add(User user) throws UserAlreadyExistExceptions, IOException {
        if (loginPresent(user.getLogin())) throw new UserAlreadyExistExceptions("User already exist in storage");
        else {
            userDataSt.put(user.getLogin(), user);
            userWriter.addUser(user.getLogin(), user.getPsw());
        }
    }

    public boolean loginPresent(String username) throws FileNotFoundException {
        //return userDataSt.containsKey(username);
        return userWriter.containsUsername(username);
    }

    public boolean passwordPresent(String login, String password) throws FileNotFoundException {
//        if (loginPresent(login)) {
//            return userDataSt.get(login).hasTheSamePasswordAs(password);
//        } else return false;
        return userWriter.containsBothUsernameAndPassword(login, password);
    }
}

