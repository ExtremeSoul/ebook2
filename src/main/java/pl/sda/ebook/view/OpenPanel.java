package pl.sda.ebook.view;

import pl.sda.ebook.exception.UserAlreadyExistExceptions;
import pl.sda.ebook.login.LogIn;
import pl.sda.ebook.registration.SignIn;

import java.util.Scanner;

public class OpenPanel {

    private SignIn signIn;
    private LogIn logIn;
    private Scanner scanner;

    public OpenPanel(SignIn signIn, LogIn logIn, Scanner scanner) {
        this.signIn = signIn;
        this.logIn = logIn;
        this.scanner = scanner;
    }

    public void openPanel() throws UserAlreadyExistExceptions {

//        Scanner scanner = new Scanner(System.in);
        boolean isWorking = true;

        showMessagesPanel();

        while (isWorking) {
            switch (Integer.valueOf(scanner.nextLine())) {
                case 1:
                    logIn.logIn();
                    showMessagesPanel();
                    break;
                case 2:
                    signIn.signIn();
                    showMessagesPanel();
                    break;
                case 3:
                    isWorking = false;
                    break;
                default:
                    System.out.println("Try again");
            }
        }
    }

    public void showMessagesPanel() {
        System.out.println("1 - Log in");
        System.out.println("2 - Sign in");
        System.out.println("3 - Exit");
    }

}
