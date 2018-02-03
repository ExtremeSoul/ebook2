package pl.sda.ebook.domain;

import pl.sda.ebook.exception.UserAlreadyExistExceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class UserStorage {
    DataWriter dataWriter = new DataWriter();

    HashMap<String, User> userDataSt = new HashMap<>();


    public void add(User user) throws UserAlreadyExistExceptions, IOException {
        if(loginPresent(user.getLogin())) throw new UserAlreadyExistExceptions("User already exist in storage");
        else {
            userDataSt.put(user.getLogin(), user);
            dataWriter.addUser(user.getLogin(), user.getPsw());
        }
    }

    public boolean loginPresent(String username) throws FileNotFoundException {
        //return userDataSt.containsKey(username);
        return dataWriter.readerUsers(username);
    }

    public boolean passwordPresent(String login, String password) throws FileNotFoundException {
//        if (loginPresent(login)) {
//            return userDataSt.get(login).hasTheSamePasswordAs(password);
//        } else return false;
        return dataWriter.containsBothUsernameAndPassword(login, password);
    }
}

