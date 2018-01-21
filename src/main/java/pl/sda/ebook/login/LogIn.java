package pl.sda.ebook.login;

import pl.sda.ebook.registration.RegistrationController;
import pl.sda.ebook.communication.Response;

import java.util.Scanner;

public class LogIn {

    private Scanner scanner;
    private RegistrationController registrationController;

    public LogIn(Scanner scanner, RegistrationController registrationController) {
        this.scanner = scanner;
        this.registrationController = registrationController;
    }

    public void logIn() {
        System.out.println("Enter your login:");
        String login = scanner.nextLine();
        System.out.println("Enter your password:");
        String psw = scanner.nextLine();
    }
}