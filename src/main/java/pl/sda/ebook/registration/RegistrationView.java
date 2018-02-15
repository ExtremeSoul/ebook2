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
        String password = systemInterface.read();

        Response response = registrationController.register(login, password);

        if (response.isSuccess()) {
            systemInterface.display("Success! You are registered");
        } else {
            systemInterface.display("Something went wrong");
            systemInterface.display(response.getMessage());
        }
    }
}
