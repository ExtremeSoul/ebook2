//package pl.sda.ebook.registration;
//
//import org.junit.Before;
//import org.junit.Test;
//import pl.sda.ebook.communication.Response;
//import pl.sda.ebook.domain.User;
//import pl.sda.ebook.domain.UserStorage;
//import pl.sda.ebook.exception.UserAlreadyExistExceptions;
//
//import java.io.IOException;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//public class RegistrationControllerTest {
//
//    private static final String VALID_LOGIN = "magda";
//
//    RegistrationController registrationController;
//    UserStorage userStorage;
//
//    @Before
//    public void setUp() {
//        userStorage = new UserStorage();
//        registrationController = new RegistrationController(userStorage);
//    }
//
//    @Test
//    public void shouldRegisterNewUser() throws UserAlreadyExistExceptions, IOException {
//
//        Response result = new RegistrationController(userStorage).register(VALID_LOGIN, "123456");
//        assertTrue(result.isSuccess());
//        assertTrue(userStorage.loginPresent(VALID_LOGIN));
//    }
//
//    @Test
//    public void shouldNotRegisterIfPswIsShort() throws UserAlreadyExistExceptions, IOException {
//
//        Response result = new RegistrationController(userStorage).register(VALID_LOGIN, "1234");
//        assertFalse(result.isSuccess());
//        assertEquals("Password is too short", result.getMessage());
//        assertFalse(userStorage.loginPresent(VALID_LOGIN));
//    }
//
//    @Test
//    public void shouldRefuseToRegisterIfUserAlreadyExists() throws UserAlreadyExistExceptions, IOException {
//
//        userStorage.add(new User(VALID_LOGIN, "123456"));
//
//        Response result = new RegistrationController(userStorage).register(VALID_LOGIN, "123456");
//        assertFalse(result.isSuccess());
//        assertEquals("User already exists", result.getMessage());
//    }
//}
