package pl.sda.ebook.view;

import pl.sda.ebook.domain.*;
import pl.sda.ebook.login.LogInView;
import pl.sda.ebook.login.LoginController;
import pl.sda.ebook.products.FileBooksStorage;
import pl.sda.ebook.products.BooksWriter;
import pl.sda.ebook.registration.RegistrationController;
import pl.sda.ebook.registration.RegistrationView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserStorageFactory userStorageFactory = new UserStorageFactory();
        UserStorage userStorage = userStorageFactory.createFileUserStorage();
        RegistrationController registrationController = new RegistrationController(userStorage);
        LoginController loginController = new LoginController(userStorage);
        BooksWriter booksWriter = new BooksWriter();
        FileBooksStorage fileBooksStorage = new FileBooksStorage(booksWriter);
        try {
            fileBooksStorage.downloadBooksDatabase();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        RegistrationView registrationView = new RegistrationView(registrationController, new CLSystemInterface(scanner));
        LogInView logInView = new LogInView(scanner, loginController, new CLSystemInterface(scanner));

        OpenPanel startOpenPanel = new OpenPanel(registrationView, logInView, scanner);
        try {
            startOpenPanel.openPanel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LoggedInMenu loggedInMenu = new LoggedInMenu(scanner);
        loggedInMenu.chooseActionAfterLoggingIn();


    }

    private static UserStorage createUserStorage() {
        UserWriter userWriter = new UserWriter();
        UserStorage userStorage = new FileUserStorage(userWriter);
        try {
            userStorage.downloadUsersDatabase();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return userStorage;
    }
}
