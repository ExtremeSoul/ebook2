package pl.sda.ebook.registration;

import org.junit.Before;
import org.junit.Test;
import pl.sda.ebook.domain.User;
import pl.sda.ebook.domain.UserStorage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegistrationControllerTest {

    private static final String VALID_LOGIN = "magda";

    RegistrationController registrationController;
    UserStorage userStorage;

    @Before
    public void setUp() {
        userStorage = new UserStorage();
        registrationController = new RegistrationController(userStorage);
    }

    @Test
    public void shouldRegisterNewUser() {

        Response result = new RegistrationController(userStorage).register(VALID_LOGIN, "123456");
        assertTrue(result.isSuccess());
        assertTrue(userStorage.present(VALID_LOGIN));
    }

    @Test
    public void shouldNotRegisterIfPswIsShort() {

        Response result = new RegistrationController(userStorage).register(VALID_LOGIN, "1234");
        assertFalse(result.isSuccess());
        assertEquals("Psw is too short", result.getMessage());
        assertFalse(userStorage.present(VALID_LOGIN));
    }

    @Test
    public void shouldRefuseToRegisterIfUserAlreadyExists() {

        userStorage.add(new User(VALID_LOGIN, "123456"));

        Response result = new RegistrationController(userStorage).register(VALID_LOGIN, "123456");
        assertFalse(result.isSuccess());
        assertEquals("User already exists", result.getMessage());
    }
}
