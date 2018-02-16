package pl.sda.ebook.registration;

import pl.sda.ebook.communication.Response;
import pl.sda.ebook.domain.User;
import pl.sda.ebook.domain.UserStorage;
import pl.sda.ebook.domain.UserAlreadyExistExceptions;

import java.io.IOException;

public class RegistrationController {
    public static final int PASSWORD_LENGTH = 6;
    private UserStorage userStorage;

    public RegistrationController(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public Response register(String username, String password) throws UserAlreadyExistExceptions, IOException {
        if (isTooShort(password)) {
            return new Response(false, "Password is too short");
        } else if (userStorage.existLogin(username)) {
            return new Response(false, "User already exists");
        } else userStorage.add(new User(username, password));
        return new Response(true);
    }

    private boolean isTooShort(String password) {
        return password.length() < PASSWORD_LENGTH;
    }
}
