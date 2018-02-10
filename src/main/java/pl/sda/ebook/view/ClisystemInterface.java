package pl.sda.ebook.view;

import java.util.Scanner;


public class ClisystemInterface implements CliInterface {

    private Scanner scanner;

    public ClisystemInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public String read() {
        return scanner.nextLine();
    }

    public void display(String message) {
        System.out.println(message);
    }
}
