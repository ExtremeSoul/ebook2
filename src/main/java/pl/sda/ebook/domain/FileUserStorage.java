package pl.sda.ebook.domain;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FileUserStorage implements UserStorage {

    private UserWriter userWriter;
    HashMap<String, User> userDataStorage = new HashMap<>();


    public FileUserStorage(UserWriter userWriter) {
        this.userWriter = userWriter;
    }

    @Override
    public void downloadUsersDatabase() throws FileNotFoundException {

        JSONParser parser = new JSONParser();

        try {
            Object object = parser.parse(new FileReader("/Users/Maluch/Documents/Prywatne/Programowanie/Git/ebook2/src/main/resources/PeopleDatabase.json"));

            JSONArray jsonArray = (JSONArray) object;
            JSONObject jsonObject = (JSONObject) jsonArray.get(0);

            String login = (String) jsonObject.get("login");
            String password = (String) jsonObject.get("password");

        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void add(User user) throws UserAlreadyExistExceptions, IOException {
        if (loginPresent(user.getLogin())) throw new UserAlreadyExistExceptions(user);
        else {
            userWriter.addUser(user.getLogin(), user.getPassword());
        }
    }

    @Override
    public boolean loginPresent(String username) throws FileNotFoundException {
        //return userDataStorage.containsKey(username);
        return userWriter.containsUsername(username);
    }

    @Override
    public boolean exist(String login, String password){
//        if (loginPresent(login)) {
//            return userDataStorage.get(login).hasTheSamePasswordAs(password);
//        } else return false;
        return true;
    }

    @Override
    public boolean exist(String login) {
        return false;
    }
}





