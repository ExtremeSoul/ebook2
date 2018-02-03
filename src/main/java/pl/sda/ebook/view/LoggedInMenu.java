package pl.sda.ebook.view;

import java.util.Scanner;

public class LoggedInMenu {
    boolean isWorking = true;
    private Scanner sc;

    public LoggedInMenu(Scanner scanner) {
        this.sc = scanner;
    }

    public void chooseActionAfterLoggingIn() {
        showMessagesPanel();

        while (isWorking)

        {
            switch (Integer.valueOf(sc.nextLine())) {
                case 1:
//                    .logIn();
//                    showMessagesPanel();
                    break;
                case 2:
                    BookMenu.bookMenuChooseAction();
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
        System.out.println("1 - Acoount settings");
        System.out.println("2 - Books Storage");
        System.out.println("3 - Buy book");
    }

}
