package pl.sda.ebook.registration;

import pl.sda.ebook.communication.Response;
import pl.sda.ebook.domain.User;
import pl.sda.ebook.domain.UserStorage;
import pl.sda.ebook.domain.UserAlreadyExistExceptions;

import java.io.IOException;

public class RegistrationController {
    private UserStorage userStorage;

    public RegistrationController(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public Response register(String username, String pswd) throws UserAlreadyExistExceptions, IOException {

        if (pswd.length() < 6) {
            return new Response(false, "Password is too short");
        } else if (userStorage.loginPresent(username)) {
            return new Response(false, "User already exists");
        } else userStorage.add(new User(username, pswd));



        return new Response(true);
    }
}
