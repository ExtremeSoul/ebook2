package pl.sda.ebook.registration;
import pl.sda.ebook.domain.UserStorage;

public class RegistrationController {

    UserStorage userStorage;


    public RegistrationController(UserStorage userStorage) {
        this.userStorage = userStorage;
    }


    public Response register(String username, String pswd) {

        Response isValid = new Response(true);

        if (pswd.length() < 6) {
            return new Response(false,"Psw is too short" );
        } else if (userStorage.present(username)) {
            return new Response(false,"User already exists" );

        }

        return isValid;
    }
}
