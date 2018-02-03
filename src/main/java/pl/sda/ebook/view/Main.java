package pl.sda.ebook.view;

import pl.sda.ebook.domain.UserWriter;
import pl.sda.ebook.domain.UserStorage;
import pl.sda.ebook.exception.UserAlreadyExistExceptions;
import pl.sda.ebook.login.LogIn;
import pl.sda.ebook.login.LoginController;
import pl.sda.ebook.products.BooksStorage;
import pl.sda.ebook.products.BooksWriter;
import pl.sda.ebook.registration.RegistrationController;
import pl.sda.ebook.registration.SignIn;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UserAlreadyExistExceptions, IOException {
        Scanner scanner = new Scanner(System.in);
        UserWriter userWriter = new UserWriter();
        UserStorage userStorage = new UserStorage(userWriter);
        RegistrationController registrationController = new RegistrationController(userStorage);
        LoginController loginController = new LoginController(userStorage);
        BooksWriter booksWriter = new BooksWriter();
        BooksStorage booksStorage = new BooksStorage(booksWriter);
        booksStorage.downloadBooksDatabase();


        SignIn signIn = new SignIn(scanner, registrationController);
        LogIn logIn = new LogIn(scanner, loginController);

        OpenPanel startOpenPanel = new OpenPanel(signIn, logIn, scanner);
        startOpenPanel.openPanel();
        LoggedInMenu loggedInMenu = new LoggedInMenu(scanner);
        loggedInMenu.chooseActionAfterLoggingIn();


    }
}
