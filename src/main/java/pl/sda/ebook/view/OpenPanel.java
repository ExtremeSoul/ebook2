package pl.sda.ebook.view;

import pl.sda.ebook.domain.UserAlreadyExistExceptions;
import pl.sda.ebook.login.LogInView;
import pl.sda.ebook.registration.RegistrationView;

import java.io.IOException;
import java.util.Scanner;

public class OpenPanel {

    private RegistrationView registrationView;
    private LogInView logInView;
    private Scanner scanner;

    public OpenPanel(RegistrationView registrationView, LogInView logInView, Scanner scanner) {
        this.registrationView = registrationView;
        this.logInView = logInView;
        this.scanner = scanner;
    }

    public void openPanel() throws UserAlreadyExistExceptions, IOException {

        boolean isWorking = true;

        showMessagesPanel();

        while (isWorking) {
            switch (Integer.valueOf(scanner.nextLine())) {
                case 1:
                    logInView.logIn();
                    showMessagesPanel();

                    break;
                case 2:
                    registrationView.signIn();
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
