package pl.sda.ebook.view;

import pl.sda.ebook.domain.UserWriter;
import pl.sda.ebook.domain.UserStorage;
import pl.sda.ebook.domain.UserAlreadyExistExceptions;
import pl.sda.ebook.login.LogInView;
import pl.sda.ebook.login.LoginController;
import pl.sda.ebook.products.BooksStorage;
import pl.sda.ebook.products.BooksWriter;
import pl.sda.ebook.registration.RegistrationController;
import pl.sda.ebook.registration.RegistrationView;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) throws UserAlreadyExistExceptions, IOException {
        Scanner scanner = new Scanner(System.in);
        UserWriter userWriter = new UserWriter();
        UserStorage userStorage = new UserStorage(userWriter);
        userStorage.downloadUsersDatabase();
        RegistrationController registrationController = new RegistrationController(userStorage);
        LoginController loginController = new LoginController(userStorage);
        BooksWriter booksWriter = new BooksWriter();
        BooksStorage booksStorage = new BooksStorage(booksWriter);
        booksStorage.downloadBooksDatabase();


        RegistrationView registrationView = new RegistrationView(registrationController, new CLSystemInterface(scanner));
        LogInView logInView = new LogInView(scanner, loginController, new CLSystemInterface(scanner));

        OpenPanel startOpenPanel = new OpenPanel(registrationView, logInView, scanner);
        startOpenPanel.openPanel();
        LoggedInMenu loggedInMenu = new LoggedInMenu(scanner);
        loggedInMenu.chooseActionAfterLoggingIn();


    }
}
