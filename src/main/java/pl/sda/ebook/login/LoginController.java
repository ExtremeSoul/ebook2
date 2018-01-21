package pl.sda.ebook.login;

import pl.sda.ebook.communication.Response;
import pl.sda.ebook.domain.UserStorage;

public class LoginController {


    private UserStorage userStorage;

    public LoginController(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public Response loginValiddation(String username, String pswd) {

        if (!(userStorage.passwordPresent(username, pswd))) {
            return new Response(false, "Password is not correct");
        } else return new Response(true);
    }
}
