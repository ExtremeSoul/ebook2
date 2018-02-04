package pl.sda.ebook.login;

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

    public Response logIn() throws FileNotFoundException {
        System.out.println("Enter your login:");
        String login = scanner.nextLine();
        System.out.println("Enter your password:");
        String psw = scanner.nextLine();

        return loginController.loginValiddation(login, psw);

    }
}