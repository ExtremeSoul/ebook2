package pl.sda.ebook.products;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BooksWriter {
    public BooksWriter() throws IOException {
    }

    public File getBooksDatabse() {
        return booksDatabse;
    }

    private File booksDatabse = new File("C:\\Users\\jakub\\Desktop\\Code\\BooksDatabase.txt");


    public void addBooktoStorage(Book book) throws IOException {
        FileWriter fw = new FileWriter(booksDatabse, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(book.getName()+";"+book.getAuthor()+";"+book.getGenre()+";"+book.getYearOfPublishing());
        bw.newLine();
        bw.close();
    }


}
