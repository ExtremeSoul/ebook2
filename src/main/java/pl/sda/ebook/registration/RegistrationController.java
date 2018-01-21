package pl.sda.ebook.registration;

import pl.sda.ebook.domain.User;
import pl.sda.ebook.domain.UserStorage;

public class RegistrationController {

    private UserStorage userStorage;

    public RegistrationController(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public Response register(String username, String pswd) {

        if (pswd.length() < 6) {
            return new Response(false, "Psw is too short");
        } else if (userStorage.present(username)) {
            return new Response(false, "User already exists");
        } else userStorage.add(new User(username, pswd));

        return new Response(true);
    }
}
