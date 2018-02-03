package pl.sda.ebook.login;

import pl.sda.ebook.registration.RegistrationController;
import pl.sda.ebook.communication.Response;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LogIn {

    private Scanner scanner;
    private LoginController loginController;

    public LogIn(Scanner scanner, LoginController loginController) {
        this.scanner = scanner;
        this.loginController = loginController;
    }

    public void logIn() throws FileNotFoundException {
        System.out.println("Enter your login:");
        String login = scanner.nextLine();
        System.out.println("Enter your password:");
        String psw = scanner.nextLine();

        Response response = loginController.loginValiddation(login, psw);

        if (response.isSuccess()) {
            System.out.println("Hello, " + login);
        } else {
            System.out.println(response.getMessage());
        }
    }
}