package pl.sda.ebook.login;

import org.junit.Before;
import org.junit.Test;
import pl.sda.ebook.communication.Response;
import pl.sda.ebook.domain.User;
import pl.sda.ebook.domain.UserStorage;
import pl.sda.ebook.domain.UserWriter;
import pl.sda.ebook.exception.UserAlreadyExistExceptions;

import java.io.IOException;

import static org.junit.Assert.*;

public class LoginControllerTest {

    private static final String VALID_LOGIN = "magda";

    LoginController loginController;
    UserStorage userStorage;
    UserWriter userWriter;

    @Before
    public void setUp() {
        userWriter = new UserWriter();
        userStorage = new UserStorage(userWriter);
        loginController = new LoginController(userStorage);
    }

    @Test
    public void shouldLogInUserWhenLoginAndPswIsCorrect() throws UserAlreadyExistExceptions, IOException {

        userStorage.add(new User(VALID_LOGIN, "123456"));
        userStorage.downloadUsersDatabase();
        Response result = new LoginController(userStorage).loginValiddation(VALID_LOGIN, "123456");
        assertTrue(result.isSuccess());
    }

    @Test
    public void shouldNotLogInUserWhenLoginAndPswIsInCorrect() throws UserAlreadyExistExceptions, IOException {

        userStorage.add(new User("Przemek", "123456"));
        userStorage.downloadUsersDatabase();
        Response result = new LoginController(userStorage).loginValiddation("kamil", "12345674");
        assertFalse(result.isSuccess());
        assertEquals("Password is not correct", result.getMessage());
    }

    @Test
    public void shouldNotLogInUserWhenLoginIsCorrectAndPswIsInCorrect() throws UserAlreadyExistExceptions, IOException {

        userStorage.add(new User("Błażej", "123456"));
        userStorage.downloadUsersDatabase();
        Response result = new LoginController(userStorage).loginValiddation("Błażej", "12345674");
        assertFalse(result.isSuccess());
        assertEquals("Password is not correct", result.getMessage());
    }


}