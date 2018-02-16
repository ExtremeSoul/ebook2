package pl.sda.ebook.view;

import pl.sda.ebook.domain.*;
import pl.sda.ebook.login.LogInView;
import pl.sda.ebook.login.LoginController;
import pl.sda.ebook.products.FileBooksStorage;
import pl.sda.ebook.registration.RegistrationController;
import pl.sda.ebook.registration.RegistrationView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserStorageFactory userStorageFactory = new UserStorageFactory();
        UserStorage userStorage = userStorageFactory.createJSONFileUserStorage();
        RegistrationController registrationController = new RegistrationController(userStorage);
        LoginController loginController = new LoginController(userStorage);
        FileBooksStorage fileBooksStorage = new FileBooksStorage("/Users/Maluch/Documents/Prywatne/Programowanie/Git/ebook2/src/main/resources/BookDatabase.json");

        RegistrationView registrationView = new RegistrationView(registrationController, new CLSystemInterface(scanner));
        LogInView logInView = new LogInView(loginController, new CLSystemInterface(scanner));

        OpenPanel startOpenPanel = new OpenPanel(registrationView, logInView, scanner);
        try {
            startOpenPanel.openPanel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LoggedInMenu loggedInMenu = new LoggedInMenu(scanner);
        loggedInMenu.chooseActionAfterLoggingIn();
    }
}
