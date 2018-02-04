package pl.sda.ebook.products;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;

public class BooksStorage {

    public HashMap<String, Book> getBooksTotalStorage() {
        return booksTotalStorage;
    }

    private HashMap<String, Book> booksTotalStorage = new HashMap<>();

    private BooksWriter booksWriter;

    public BooksStorage(BooksWriter booksWriter) {
        this.booksWriter = booksWriter;
    }

    public void downloadBooksDatabase() throws FileNotFoundException {
        booksTotalStorage.clear();
        Scanner scanner = new Scanner(booksWriter.getBooksDatabse());
        while (scanner.hasNextLine()) {
            String name = null;
            String author = null;
            String genre = null;
            String yearOfPublishing = null;
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            name = parts[0];
            author = parts[1];
            genre = parts[2];
            yearOfPublishing = parts[3];
            int year = Integer.parseInt(yearOfPublishing);
            Book book = new Book(name, author, genre, year);
            booksTotalStorage.put(book.getName(), book);
        }
    }

    public void printDownListOfAllBooks() {
        Stream.of(booksTotalStorage.keySet().toString())
                .forEach(System.out::println);
    }

}

//
//    public void showListOfBooksAndAuthors(){
//        String bookTitleList = null;
//        if(bookTitleList != null){
//        System.out.println(bookTitleList);}
//        else System.out.println("Niestety, ale nie mamy żadnych książek");
//    }


