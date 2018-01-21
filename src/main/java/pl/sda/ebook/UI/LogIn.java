package pl.sda.ebook.UI;

import pl.sda.ebook.registration.RegistrationController;

import java.util.Scanner;

public class LogIn {

    private Scanner scanner;
    private RegistrationController registrationController;

    public LogIn(Scanner scanner, RegistrationController registrationController) {
        this.scanner = scanner;
        this.registrationController = registrationController;
    }

    public void logIn() {
        System.out.println("");
    }
}
