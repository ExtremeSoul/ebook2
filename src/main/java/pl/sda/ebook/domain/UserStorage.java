package pl.sda.ebook.domain;

import pl.sda.ebook.exception.UserAlreadyExistExceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class UserStorage {
    public UserWriter userWriter() {
        return userWriter;
    }

    private UserWriter userWriter;
    HashMap<String, User> userDataStorage = new HashMap<>();


    public UserStorage(UserWriter userWriter) {
        this.userWriter = userWriter;
    }

    public void downloadUsersDatabase() throws FileNotFoundException {
        Scanner scanner = new Scanner(userWriter.getUserDatabase());
        while (scanner.hasNextLine()) {
            String name = null;
            String password = null;
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            parts[0] = name;
            parts[1] = password;
            User user = new User(name, password);
            userDataStorage.put(user.getLogin(), user);
        }
    }


    public void add(User user) throws UserAlreadyExistExceptions, IOException {
        if (loginPresent(user.getLogin())) throw new UserAlreadyExistExceptions("User already exist in storage");
        else {
            userWriter.addUser(user.getLogin(), user.getPsw());
        }
    }

    public boolean loginPresent(String username) throws FileNotFoundException {
        //return userDataStorage.containsKey(username);
        return userWriter.containsUsername(username);
    }

    public boolean passwordPresent(String login, String password) throws FileNotFoundException {
//        if (loginPresent(login)) {
//            return userDataStorage.get(login).hasTheSamePasswordAs(password);
//        } else return false;
        return userWriter.containsBothUsernameAndPassword(login, password);
    }
}

