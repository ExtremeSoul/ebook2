package pl.sda.ebook.UI;

import pl.sda.ebook.domain.UserStorage;
import pl.sda.ebook.registration.RegistrationController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UserStorage userStorage = new UserStorage();
        RegistrationController registrationController = new RegistrationController(userStorage);

        Scanner scanner = new Scanner(System.in);
        SignIn signIn = new SignIn(scanner, registrationController);
        LogIn logIn = new LogIn(scanner, registrationController);

        OpenPanel startOpenPanel = new OpenPanel(signIn, logIn);

        startOpenPanel.openPanel();

    }


}
