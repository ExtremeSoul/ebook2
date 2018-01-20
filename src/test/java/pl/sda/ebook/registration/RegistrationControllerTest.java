package pl.sda.ebook.registration;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.ebook.domain.UserStorage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegistrationControllerTest {

    @Test
    public void shouldRegisterNewUser() {
        UserStorage userStorage = new UserStorage();

        RegistrationController registrationController = new RegistrationController(userStorage);
        Response result = new RegistrationController(userStorage).register("magda", "123456");
        assertTrue(result.isSuccess());
    }

    @Test
    public void shouldNotRegisterIfPswIsShort() {
        UserStorage userStorage = new UserStorage();

        RegistrationController registrationController = new RegistrationController(userStorage);
        Response result = new RegistrationController(userStorage).register("magda", "1234");
        assertFalse(result.isSuccess());
        assertEquals("Psw is too short", result.getMessage());
    }

    @Test
    public void shouldRefuseToRegiserIfUserAlreadyExists() {
        UserStorage userStorage = new UserStorage();
        userStorage.add("magda", "123456");

        Response result = new RegistrationController(userStorage).register("magda", "123456");

        assertFalse(result.isSuccess());
        assertEquals("User already exists", result.getMessage());
    }
}
