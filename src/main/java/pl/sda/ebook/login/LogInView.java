package pl.sda.ebook.login;

import pl.sda.ebook.communication.Response;
import pl.sda.ebook.view.SystemInterface;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LogInView {

    private Scanner scanner;
    private LoginController loginController;
    private final SystemInterface systemInterface;

    public LogInView(Scanner scanner, LoginController loginController, SystemInterface systemInterface) {
        this.scanner = scanner;
        this.loginController = loginController;
        this.systemInterface = systemInterface;
    }

    public void logIn() throws FileNotFoundException {
        systemInterface.display("Enter your login:");
        String login = systemInterface.read();
        systemInterface.display("Enter your password:");
        String psw = systemInterface.read();

        Response response = loginController.loginValiddation(login, psw);

        if (response.isSuccess()) {
            systemInterface.display("Hello, " + login);

        } else {
            systemInterface.display(response.getMessage());
        }
    }
}