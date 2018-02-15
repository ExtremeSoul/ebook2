package pl.sda.ebook.login;

import org.junit.Test;
import org.mockito.BDDMockito;
import pl.sda.ebook.communication.Response;
import pl.sda.ebook.domain.*;
import java.io.IOException;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class LoginControllerTest {

    public static final String LOGIN = "Magda";
    public static final String PASSWORD = "123456";
    private final UserStorage userStorage = mock(UserStorage.class);

    @Test
    public void shouldLogInUserWhenLoginAndPswIsCorrect() throws UserAlreadyExistExceptions, IOException {
        BDDMockito.given(userStorage.exist(LOGIN, PASSWORD)).willReturn(true);

        Response result = new LoginController(userStorage).loginValiddation(LOGIN, PASSWORD);

        assertTrue(result.isSuccess());
    }

    @Test
    public void shouldNotLogInUserWhenLoginAndPswIsInCorrect() throws UserAlreadyExistExceptions, IOException {
        BDDMockito.given(userStorage.exist(LOGIN, PASSWORD)).willReturn(true);

        Response result = new LoginController(userStorage).loginValiddation("kamil", "12345674");

        assertFalse(result.isSuccess());
        assertEquals("Login or password isn't correct", result.getMessage());
    }

    @Test
    public void shouldNotLogInUserWhenLoginIsCorrectAndPswIsInCorrect() throws UserAlreadyExistExceptions, IOException {
        BDDMockito.given(userStorage.exist(LOGIN, PASSWORD)).willReturn(true);

        Response result = new LoginController(userStorage).loginValiddation(LOGIN, "12345674");

        assertFalse(result.isSuccess());
        assertEquals("Login or password isn't correct", result.getMessage());
    }
}