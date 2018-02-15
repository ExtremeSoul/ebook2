package pl.sda.ebook.registration;

import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import pl.sda.ebook.communication.Response;
import pl.sda.ebook.view.CLSystemInterface;
import static org.mockito.Mockito.mock;

public class RegistrationViewTest {

    private final String SOME_PASSWORD = "login";
    private final String SOME_LOGIN = "password";

    private RegistrationController registrationController = mock(RegistrationController.class);
    private CLSystemInterface CLSystemInterface = mock(CLSystemInterface.class);
    private RegistrationView signIn = new RegistrationView(registrationController, CLSystemInterface);

    @Test
    public void shouldRegisterNewUser() throws Exception {

        Response response = new Response(true);
        BDDMockito.given(CLSystemInterface.read()).willReturn(SOME_LOGIN, SOME_PASSWORD);
        BDDMockito.given(registrationController.register(SOME_LOGIN, SOME_PASSWORD)).willReturn(response);

        signIn.signIn();

        Mockito.verify(CLSystemInterface).display("Success! You are registered");
    }

    @Test
    public void shouldNotRegisterNewUserWhenUserAlreadyExist() throws Exception {

        String user_already_exists = "User already exists";
        Response response = new Response(false, user_already_exists);
        BDDMockito.given(CLSystemInterface.read()).willReturn(SOME_LOGIN, SOME_PASSWORD);
        BDDMockito.given(registrationController.register(SOME_LOGIN, SOME_PASSWORD)).willReturn(response);

        signIn.signIn();

        Mockito.verify(CLSystemInterface).display(user_already_exists);
//    }
    }
}