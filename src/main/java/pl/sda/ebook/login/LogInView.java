package pl.sda.ebook.login;

import pl.sda.ebook.communication.Response;
import pl.sda.ebook.view.SystemInterface;
import java.io.FileNotFoundException;

public class LogInView {

    private LoginController loginController;
    private final SystemInterface systemInterface;

    public LogInView(LoginController loginController, SystemInterface systemInterface) {
        this.loginController = loginController;
        this.systemInterface = systemInterface;
    }

    public void logIn() throws FileNotFoundException {
        systemInterface.display("Enter your login:");
        String login = systemInterface.read();
        systemInterface.display("Enter your password:");
        String password = systemInterface.read();

        Response response = loginController.loginValiddation(login, password);

        if (response.isSuccess()) {
            systemInterface.display("Hello, " + login);
        } else {
            systemInterface.display("Something went wrong");
            systemInterface.display(response.getMessage());
        }
    }
}