package pl.sda.ebook.view;

import pl.sda.ebook.exception.UserAlreadyExistExceptions;
import pl.sda.ebook.registration.RegistrationController;
import pl.sda.ebook.communication.Response;

import java.io.IOException;
import java.util.Scanner;

public class RegistrationView implements CliInterface {

    private Scanner scanner;
    private RegistrationController registrationController;
    private SystemInterface systemInterface;

    public RegistrationView(Scanner scanner, RegistrationController registrationController, SystemInterface systemInterface) {
        this.scanner = scanner;
        this.registrationController = registrationController;
        this.systemInterface = systemInterface;
    }

    public Response signIn() throws UserAlreadyExistExceptions, IOException {

        systemInterface.display("Write login");
        String login = systemInterface.readInformation();
        systemInterface.display("Write password");
        String psw = systemInterface.readInformation();


//        Response response = registrationController.register(login, psw);
//        if (response.isSuccess()) {
//            System.out.println("Success!");
//        } else {
//            System.out.println(response.getMessage());
//        }
        return registrationController.register(login, psw);
    }
}
