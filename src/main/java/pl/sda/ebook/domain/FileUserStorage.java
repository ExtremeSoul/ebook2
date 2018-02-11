package pl.sda.ebook.domain;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class FileUserStorage implements UserStorage {

    private UserWriter userWriter;
    HashMap<String, User> userDataStorage = new HashMap<>();


    public FileUserStorage(UserWriter userWriter) {
        this.userWriter = userWriter;
    }

    @Override
    public void downloadUsersDatabase() throws FileNotFoundException {
        Scanner scanner = new Scanner(userWriter.getUserDatabase());
        while (scanner.hasNextLine()) {
            String name = null;
            String password = null;
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            name = parts[0];
            password = parts[1];
            User user = new User(name, password);
            userDataStorage.put(user.getLogin(), user);
        }
    }

    @Override
    public void add(User user) throws UserAlreadyExistExceptions, IOException {
        if (loginPresent(user.getLogin())) throw new UserAlreadyExistExceptions(user);
        else {
            userWriter.addUser(user.getLogin(), user.getPsw());
        }
    }

    @Override
    public boolean loginPresent(String username) throws FileNotFoundException {
        //return userDataStorage.containsKey(username);
        return userWriter.containsUsername(username);
    }

    @Override
    public boolean passwordPresent(String login, String password) throws FileNotFoundException {
//        if (loginPresent(login)) {
//            return userDataStorage.get(login).hasTheSamePasswordAs(password);
//        } else return false;
        return userWriter.containsBothUsernameAndPassword(login, password);
    }
}

