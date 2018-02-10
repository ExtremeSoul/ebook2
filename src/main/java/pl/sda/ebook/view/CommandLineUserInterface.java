package pl.sda.ebook.view;

import java.util.Scanner;

public class CommandLineUserInterface implements CliInterface {
    private Scanner scanner;

    public CommandLineUserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readInformation() {
        String recivedInformation = scanner.nextLine();
        return recivedInformation;
    }

    public void display(String message) {
        System.out.println(message);
    }
}
