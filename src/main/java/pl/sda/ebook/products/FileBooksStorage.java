package pl.sda.ebook.products;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class FileBooksStorage {

    HashMap<String, Book> booksTotalStorage = new HashMap<>();

    private BooksWriter booksWriter;

    public FileBooksStorage(BooksWriter booksWriter) {
        this.booksWriter = booksWriter;
    }

    public void downloadBooksDatabase() throws FileNotFoundException {
        Scanner scanner = new Scanner(booksWriter.getBooksDatabse());
        while (scanner.hasNextLine()) {
            String name = null;
            String author = null;
            String genre = null;
            String yearOfPublishing = null;
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            parts[0] = name;
            parts[1] = author;
            parts[2] = genre;
            parts[3] = yearOfPublishing;
            int year = Integer.parseInt(yearOfPublishing);
            Book book = new Book(name, author, genre,year );
            booksTotalStorage.put(book.getName(),book);
        }
    }


    public void addBookToStorage(Book book) throws IOException {
//        booksTotalStorage.put(book.getName(), book);
        booksWriter.addBookToStorage(book);
    }

    public void showListOfBooksAndAuthors(){
        String bookTitleList = null;
        if(bookTitleList != null){
        System.out.println(bookTitleList);}
        else System.out.println("Niestety, ale nie mamy żadnych książek");
    }

}
