package pl.sda.ebook.registration;

import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import pl.sda.ebook.communication.Response;
import pl.sda.ebook.view.CliInterface;
import pl.sda.ebook.view.ClisystemInterface;

import static org.mockito.Mockito.mock;

public class SignInTest {
    private final String SOME_PASSWORD = "login";
    private final String SOME_LOGIN = "password";

    private RegistrationController registrationController = mock(RegistrationController.class);
    private ClisystemInterface clisystemInterface = mock(ClisystemInterface.class);
    private SignIn signIn = new SignIn(registrationController, clisystemInterface);

    @Test
    public void shouldRegisterNewUser() throws Exception {

        Response response = new Response(true);
        BDDMockito.given(clisystemInterface.read()).willReturn(SOME_LOGIN, SOME_PASSWORD);
        BDDMockito.given(registrationController.register(SOME_LOGIN, SOME_PASSWORD)).willReturn(response);

        signIn.signIn();

        Mockito.verify(clisystemInterface).display("Success!");
    }

    @Test
    public void shouldNotRegisterNewUserWhenUserAlreadyExist() throws Exception {

        String user_already_exists = "User already exists";
        Response response = new Response(false, user_already_exists);
        BDDMockito.given(clisystemInterface.read()).willReturn(SOME_LOGIN, SOME_PASSWORD);
        BDDMockito.given(registrationController.register(SOME_LOGIN, SOME_PASSWORD)).willReturn(response);

        signIn.signIn();

        Mockito.verify(clisystemInterface).display(user_already_exists);
//    }
    }
}