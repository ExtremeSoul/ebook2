package pl.sda.ebook.view;

import pl.sda.ebook.exception.UserAlreadyExistExceptions;
import pl.sda.ebook.registration.RegistrationController;
import pl.sda.ebook.communication.Response;

import java.io.IOException;
import java.util.Scanner;

public class RegistrationView implements CliInterface {

    private Scanner scanner;
    private RegistrationController registrationController;
    private CommandLineUserInterface commandLineUserInterface;

    public RegistrationView(Scanner scanner, RegistrationController registrationController, CommandLineUserInterface commandLineUserInterface) {
        this.scanner = scanner;
        this.registrationController = registrationController;
        this.commandLineUserInterface = commandLineUserInterface;
    }

    public Response signIn() throws UserAlreadyExistExceptions, IOException {

        commandLineUserInterface.display("Write login");
        String login = commandLineUserInterface.readInformation();
        commandLineUserInterface.display("Write password");
        String psw = commandLineUserInterface.readInformation();
        return registrationController.register(login, psw);
    }
}
