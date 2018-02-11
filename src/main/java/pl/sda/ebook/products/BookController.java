package pl.sda.ebook.products;

import pl.sda.ebook.communication.Response;
import pl.sda.ebook.domain.EBooksStorage;

public class BookController {
    private EBooksStorage booksStorage;

    public BookController(EBooksStorage booksStorage) {

        this.booksStorage = booksStorage;
    }

    public Response addBook(String title, String author) {
        booksStorage.addBook(title, author);
        return new Response(true);
    }
}
