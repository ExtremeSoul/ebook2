package pl.sda.ebook.view;

import pl.sda.ebook.domain.UserStorage;
import pl.sda.ebook.exception.UserAlreadyExistExceptions;
import pl.sda.ebook.login.LogIn;
import pl.sda.ebook.login.LoginController;
import pl.sda.ebook.registration.RegistrationController;
import pl.sda.ebook.registration.SignIn;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UserAlreadyExistExceptions {

        UserStorage userStorage = new UserStorage();
        RegistrationController registrationController = new RegistrationController(userStorage);
        LoginController loginController = new LoginController(userStorage);

        Scanner scanner = new Scanner(System.in);
        SignIn signIn = new SignIn(scanner, registrationController);
        LogIn logIn = new LogIn(scanner, loginController);

        OpenPanel startOpenPanel = new OpenPanel(signIn, logIn, scanner);
        startOpenPanel.openPanel();

    }
}
