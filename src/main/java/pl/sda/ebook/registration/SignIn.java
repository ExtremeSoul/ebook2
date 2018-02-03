package pl.sda.ebook.registration;

import pl.sda.ebook.exception.UserAlreadyExistExceptions;
import pl.sda.ebook.registration.RegistrationController;
import pl.sda.ebook.communication.Response;

import java.io.IOException;
import java.util.Scanner;

public class SignIn {

    private Scanner scanner;
    private RegistrationController registrationController;

    public SignIn(Scanner scanner, RegistrationController registrationController) {
        this.scanner = scanner;
        this.registrationController = registrationController;
    }

    public void signIn() throws UserAlreadyExistExceptions, IOException {

        System.out.println("Enter your login:");
        String login = scanner.nextLine();
        System.out.println("Enter your password:");
        String psw = scanner.nextLine();

        Response response = registrationController.register(login, psw);

        if (response.isSuccess()) {
            System.out.println("Success!");
        } else {
            System.out.println(response.getMessage());
        }
    }
}
