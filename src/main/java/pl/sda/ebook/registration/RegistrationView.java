package pl.sda.ebook.registration;

import pl.sda.ebook.domain.UserAlreadyExistExceptions;
import pl.sda.ebook.communication.Response;
import pl.sda.ebook.view.SystemInterface;
import java.io.IOException;

public class RegistrationView {

    private RegistrationController registrationController;
    private final SystemInterface systemInterface;

    public RegistrationView(RegistrationController registrationController, SystemInterface systemInterface) {
        this.registrationController = registrationController;
        this.systemInterface = systemInterface;
    }

    public void signIn() throws UserAlreadyExistExceptions, IOException {

        systemInterface.display("Enter your login:");
        String login = systemInterface.read();
        systemInterface.display("Enter your password:");
        String psw = systemInterface.read();

        Response response = registrationController.register(login, psw);

        if (response.isSuccess()) {
            systemInterface.display("Success!");
        } else {
            systemInterface.display(response.getMessage());
        }
    }
}
