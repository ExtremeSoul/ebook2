package pl.sda.ebook.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.HashMap;

public class JSONFileUserStorage implements UserStorage {

    private File userDatabase = new File("/Users/Maluch/Documents/Prywatne/Programowanie/Git/ebook2/src/main/resources/PeopleDatabase.json");
    HashMap<String, User> userDataStorageMap = new HashMap<>();

    @Override
    public void add(User user) throws UserAlreadyExistExceptions {
        if (existLogin(user.getLogin())) throw new UserAlreadyExistExceptions(user);
        else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("login:", String.format("\"%s\"", user.getLogin()));
            jsonObject.put("password:", "\"" + user.getPassword() + "\"");
            try (FileWriter fileWriter = new FileWriter(userDatabase, true)) {
                fileWriter.write(jsonObject.toJSONString());
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean existUser(String login, String password) {
        if (existLogin(login)) {
            return userDataStorageMap.get(login).hasTheSamePasswordAs(password);
        }
        return false;
    }

    @Override
    public boolean existLogin(String login) {
        userDataStorageMap = downloadUsersDatabase();
        if (userDataStorageMap.containsKey(login)) {
            return true;
        }
        return false;
    }

    @Override
    public HashMap downloadUsersDatabase() {
        return convertFileToMap();
    }

    private HashMap convertFileToMap() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            userDataStorageMap = objectMapper.readValue(userDatabase, new TypeReference<HashMap<String, User>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userDataStorageMap;
    }
}







