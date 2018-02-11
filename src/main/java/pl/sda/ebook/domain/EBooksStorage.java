package pl.sda.ebook.domain;

import pl.sda.ebook.communication.Response;
import pl.sda.ebook.products.Book;

public interface EBooksStorage {
    void addBook(String title, String author, String isbn);

    boolean isAlreadyExist(Response informationAbout);

    Book searchBy(String isbn);
}
