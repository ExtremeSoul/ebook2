package pl.sda.ebook.registration;

import org.junit.Test;
import org.mockito.BDDMockito;
import pl.sda.ebook.communication.Response;
import pl.sda.ebook.domain.*;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class RegistrationControllerTest {

    private static final String VALID_LOGIN = "magda";
    public static final String PASSWORD = "123456";
    public static final String PASSWORD_INCORRECT = "1234";
    private final UserStorage userStorage = mock(UserStorage.class);

    @Test
    public void shouldRegisterNewUser() throws UserAlreadyExistExceptions, IOException {
        Response result = new RegistrationController(userStorage).register(VALID_LOGIN, PASSWORD);

        assertTrue(result.isSuccess());
        verify(this.userStorage).exist(VALID_LOGIN);
    }

    @Test
    public void shouldNotRegisterIfPswIsShort() throws UserAlreadyExistExceptions, IOException {
        Response result = new RegistrationController(userStorage).register(VALID_LOGIN, PASSWORD_INCORRECT);

        assertFalse(result.isSuccess());
        assertEquals("Password is too short", result.getMessage());
        verify(this.userStorage, never()).add(new User(VALID_LOGIN, PASSWORD_INCORRECT));
    }

    @Test
    public void shouldRefuseToRegisterIfUserAlreadyExists() throws UserAlreadyExistExceptions, IOException {
        BDDMockito.given(userStorage.exist(VALID_LOGIN)).willReturn(true);

        Response result = new RegistrationController(userStorage).register(VALID_LOGIN, PASSWORD);

        assertFalse(result.isSuccess());
        assertEquals("User already exists", result.getMessage());
        verify(this.userStorage, never()).add(new User(VALID_LOGIN, PASSWORD));
    }
}
