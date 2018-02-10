package pl.sda.ebook.view;

import java.util.Scanner;


public class CLSystemInterface implements SystemInterface {

    private Scanner scanner;

    public CLSystemInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public String read() {
        return scanner.nextLine();
    }

    public void display(String message) {
        System.out.println(message);
    }
}
