package pl.sda.ebook.domain;

import java.io.*;
import java.util.Scanner;

public class DataWriter {

    private File userDatabase = new File("C:\\Users\\Dell\\Desktop\\InScholProject\\Kamil\\ebook2\\usersDatabase.txt");


    public void addUser(String username, String pswd) throws IOException {
        FileWriter fw = new FileWriter(userDatabase, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(username + ";" + pswd);
        bw.newLine();
        bw.close();
    }


    public boolean readerUsers(String username) throws FileNotFoundException {

        Scanner scanner = new Scanner(userDatabase);
        boolean contain = false;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.contains(username)) {
                contain = true;
            }
        }
        return contain;
    }

}
