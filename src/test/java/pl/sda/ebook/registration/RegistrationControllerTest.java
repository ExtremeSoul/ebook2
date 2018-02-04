package pl.sda.ebook.registration;

import org.junit.Before;
import org.junit.Test;
import pl.sda.ebook.communication.Response;
import pl.sda.ebook.domain.User;
import pl.sda.ebook.domain.UserStorage;
import pl.sda.ebook.domain.UserWriter;
import pl.sda.ebook.exception.UserAlreadyExistExceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegistrationControllerTest {

    private static final String VALID_LOGIN = "magda";
    UserWriter userWriter;
    RegistrationController registrationController;
    UserStorage userStorage;

    @Before
    public void setUp() throws FileNotFoundException {
        userWriter = new UserWriter();
        userStorage = new UserStorage(userWriter);
        userStorage.downloadUsersDatabase();
        registrationController = new RegistrationController(userStorage);
    }

    @Test
    public void shouldRegisterNewUser() throws UserAlreadyExistExceptions, IOException {

        Response result = new RegistrationController(userStorage).register(VALID_LOGIN, "123456");
        assertTrue(result.isSuccess());
        userStorage.downloadUsersDatabase();
        assertTrue(userStorage.loginPresent(VALID_LOGIN));
    }

    @Test
    public void shouldNotRegisterIfPswIsShort() throws UserAlreadyExistExceptions, IOException {

        Response result = new RegistrationController(userStorage).register(VALID_LOGIN, "1234");
        userStorage.downloadUsersDatabase();
        assertFalse(result.isSuccess());
        assertEquals("Password is too short", result.getMessage());
    }

    @Test
    public void shouldRefuseToRegisterIfUserAlreadyExists() throws UserAlreadyExistExceptions, IOException {

        userStorage.add(new User("kuba", "1234567"));
        userStorage.downloadUsersDatabase();
        Response result = new RegistrationController(userStorage).register("kuba", "1234567");
        assertFalse(result.isSuccess());
        assertEquals("User already exists", result.getMessage());
    }
}
