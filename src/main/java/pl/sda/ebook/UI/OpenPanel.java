package pl.sda.ebook.UI;

import java.util.Scanner;

public class OpenPanel {

    private SignIn signIn;
    private LogIn logIn;

    public OpenPanel(SignIn signIn, LogIn logIn) {
        this.signIn = signIn;
        this.logIn = logIn;
    }

    public void openPanel() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Log in");
        System.out.println("2 - Sign in");

        switch (scanner.nextInt()) {
            case 1:
                logIn.logIn();
                break;
            case 2:
                signIn.signIn();
                break;
            default:
                System.out.println("Try again");
        }
    }

}
