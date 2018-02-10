package pl.sda.ebook.registration;

import pl.sda.ebook.exception.UserAlreadyExistExceptions;
import pl.sda.ebook.communication.Response;
import pl.sda.ebook.view.CliInterface;

import java.io.IOException;
import java.util.Scanner;

public class SignIn {

    private RegistrationController registrationController;
    private final CliInterface systemInterface;

    public SignIn(RegistrationController registrationController, CliInterface systemInterface) {
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
