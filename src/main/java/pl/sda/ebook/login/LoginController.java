package pl.sda.ebook.login;

import pl.sda.ebook.communication.Response;
import pl.sda.ebook.domain.UserStorage;

public class LoginController {

    private UserStorage userStorage;

    public LoginController(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public Response loginValiddation(String username, String pswd) {
        if ((userStorage.existUser(username, pswd))) {
            return new Response(true);
        }
        return new Response(false, "Login or password isn't correct");
    }
}
