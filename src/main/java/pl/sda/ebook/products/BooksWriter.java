package pl.sda.ebook.products;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BooksWriter {
    public BooksWriter() {
    }

    public File getBooksDatabse() {
        return booksDatabse;
    }

    private File booksDatabse = new File("C:\\Users\\Dell\\Desktop\\InScholProject\\Kamil\\ebook2\\BooksDatabase.txt");

    public void addBookToStorage(Book book) throws IOException {
        FileWriter fw = new FileWriter(booksDatabse, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(book.getName()+";"+book.getAuthor()+";"+book.getGenre()+";"+book.getYearOfPublishing());
        bw.newLine();
        bw.close();
    }


}
