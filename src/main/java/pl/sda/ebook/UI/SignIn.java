package pl.sda.ebook.UI;

import pl.sda.ebook.registration.RegistrationController;
import pl.sda.ebook.registration.Response;

import java.util.Scanner;

public class SignIn {

    private Scanner scanner;
    private RegistrationController registrationController;

    public SignIn(Scanner scanner, RegistrationController registrationController) {
        this.scanner = scanner;
        this.registrationController = registrationController;
    }

    public void signIn() {

        System.out.println("Enter your login:");
        String login = scanner.nextLine();
        System.out.println("Enter your password:");
        String psw = scanner.nextLine();

        Response res = registrationController.register(login, psw);

        if (res.isSuccess()) {
            System.out.println("Success!");
        } else {
            System.out.println(res.getMessage());
        }
    }
}
