package pl.sda.ebook.login;

import org.junit.Before;
import org.junit.Test;
import pl.sda.ebook.communication.Response;
import pl.sda.ebook.domain.User;
import pl.sda.ebook.domain.UserStorage;
import pl.sda.ebook.exception.UserAlreadyExistExceptions;

import static org.junit.Assert.*;

public class LoginControllerTest {

    private static final String VALID_LOGIN = "magda";

    LoginController loginController;
    UserStorage userStorage;

    @Before
    public void setUp() {
        userStorage = new UserStorage();
        loginController = new LoginController(userStorage);
    }

    @Test
    public void shouldLogInUserWhenLoginAndPswIsCorrect() throws UserAlreadyExistExceptions {

        userStorage.add(new User(VALID_LOGIN, "123456"));

        Response result = new LoginController(userStorage).loginValiddation(VALID_LOGIN, "123456");
        assertTrue(result.isSuccess());
    }

    @Test
    public void shouldNotLogInUserWhenLoginAndPswIsInCorrect() throws UserAlreadyExistExceptions {

        userStorage.add(new User(VALID_LOGIN, "123456"));

        Response result = new LoginController(userStorage).loginValiddation(VALID_LOGIN, "12345674");
        assertFalse(result.isSuccess());
        assertEquals("Password is not correct", result.getMessage());
    }


}