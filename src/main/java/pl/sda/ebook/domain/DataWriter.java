package pl.sda.ebook.domain;

import java.io.*;

public class DataWriter {

    private File userDatabase = new File("C:\\Users\\jakub\\Desktop\\Code\\UsersDatabase.txt");


    public void addUser(String username, String pswd) throws IOException {
        FileWriter fw = new FileWriter(userDatabase, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write( username +";" + pswd);
        bw.newLine();
        bw.close();
    }

}
