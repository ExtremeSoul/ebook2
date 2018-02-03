package pl.sda.ebook.domain;

import java.io.*;
import java.util.Scanner;

public class UserWriter {
    private File userDatabase = new File("C:\\Users\\jakub\\Desktop\\Code\\UsersDatabase.txt");



    public boolean containsUsername(String userName) throws FileNotFoundException {
        Scanner scanner = new Scanner(userDatabase);
        boolean contains = false;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            if (parts[0].contains(userName)) {
                contains = true;
            }
        }return contains;
    }

    public void addUser(String username, String pswd) throws IOException {
        FileWriter fw = new FileWriter(userDatabase, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(username + ";" + pswd);
        bw.newLine();
        bw.close();
    }

    public boolean containsBothUsernameAndPassword(String login, String password) throws FileNotFoundException {
        Scanner scanner = new Scanner(userDatabase);
        boolean contains = false;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.contains(login+";"+password)) {
                contains = true;
            }
        }return contains;
    }

}
