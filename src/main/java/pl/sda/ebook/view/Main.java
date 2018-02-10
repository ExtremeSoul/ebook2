package pl.sda.ebook.view;

import pl.sda.ebook.communication.Response;
import pl.sda.ebook.domain.UserWriter;
import pl.sda.ebook.domain.UserStorage;
import pl.sda.ebook.exception.UserAlreadyExistExceptions;
import pl.sda.ebook.login.LogIn;
import pl.sda.ebook.login.LoginController;
import pl.sda.ebook.products.Book;
import pl.sda.ebook.products.BooksStorage;
import pl.sda.ebook.products.BooksWriter;
import pl.sda.ebook.registration.RegistrationController;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public enum State {
        INIT,
        LOGGING_IN,
        SIGNING_IN,
        LOGGED_IN_MENU,
        ShOW_BOOKS,
        EXIT,
    }

    public static void main(String[] args) throws UserAlreadyExistExceptions, IOException {
        Scanner scanner = new Scanner(System.in);
        CommandLineUserInterface commandLineUserInterface = new CommandLineUserInterface(scanner);
        UserWriter userWriter = new UserWriter();
        UserStorage userStorage = new UserStorage(userWriter);
        userStorage.downloadUsersDatabase();
        RegistrationController registrationController = new RegistrationController(userStorage);
        LoginController loginController = new LoginController(userStorage);
        BooksWriter booksWriter = new BooksWriter();
        BooksStorage booksStorage = new BooksStorage(booksWriter);
        booksStorage.downloadBooksDatabase();
        State state = State.INIT;


        while (state != State.EXIT) {
            switch (state) {
                case INIT: {
                    System.out.println("1 - Log in");
                    System.out.println("2 - Sign in");
                    System.out.println("3 - Exit");

                    switch (Integer.valueOf(scanner.nextLine())) {
                        case 1:
                            state = State.LOGGING_IN;
                            break;

                        case 2:
                            state = State.SIGNING_IN;
                            break;

                        case 3:
                            state = State.EXIT;
                            break;

                        default:
                            System.out.println("Try again");
                            state = State.INIT;
                            break;
                    }


                    state = logIn(scanner, loginController);
                    break;
                }
                case SIGNING_IN: {
                    state = signingIn(scanner, registrationController, commandLineUserInterface);
                    break;
                }
                case LOGGING_IN: {
                    state = logIn(scanner, loginController);
                    break;
                }
                case LOGGED_IN_MENU:
                    state = loggedInMenu(scanner, booksWriter);
                    break;
            }
        }
    }

    private static State signingIn(Scanner scanner, RegistrationController registrationController, CommandLineUserInterface commandLineUserInterface) throws IOException,
            UserAlreadyExistExceptions {
        RegistrationView registrationView = new RegistrationView(scanner, registrationController, commandLineUserInterface);
        Response response = registrationView.signIn();

        if (response.isSuccess()) {
            System.out.println("Success!");
            return State.LOGGED_IN_MENU;
        } else {
            System.out.println(response.getMessage());
            return State.SIGNING_IN;
        }
    }


    private static State logIn(Scanner scanner,
                               LoginController loginController) throws IOException, UserAlreadyExistExceptions {


        LogIn logIn = new LogIn(scanner, loginController);

        Response response = logIn.logIn();
        if (response.isSuccess()) {
            System.out.println("Hello");
            return State.LOGGED_IN_MENU;
        } else {
            System.out.println(response.getMessage());
            return State.INIT;
        }
    }

    private static State loggedInMenu(Scanner scanner, BooksWriter booksWriter) throws IOException {

        System.out.println("Jesteś zalogowany, co chciałbyś zrobić?");
        System.out.println("1 - dodaj książkę");
        System.out.println("2 - wypisz książki");
        switch (Integer.valueOf(scanner.nextLine())) {
            case 1:
                System.out.println("Podaj nazwę książki: ");
                String name = scanner.nextLine();
                System.out.println("Podaj autora:");
                String author = scanner.nextLine();
                System.out.println("Podaj gatunek:");
                String genre = scanner.nextLine();
                System.out.println("Podaj rok produkcji: ");
                int yearOfProduction = scanner.nextInt();
                scanner.nextLine();
                Book book = new Book(name, author, genre, yearOfProduction);
                booksWriter.addBooktoStorage(book);
                break;
            case 2:
                BooksStorage booksStorage = new BooksStorage(booksWriter);
                booksStorage.downloadBooksDatabase();
                booksStorage.printDownListOfAllBooks();
                break;
        }

        return State.LOGGED_IN_MENU;
//        return State.LOGGED_IN_MENU;
    }

}

