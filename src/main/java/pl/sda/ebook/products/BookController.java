package pl.sda.ebook.products;

import pl.sda.ebook.communication.Response;

public class BookController {
    private final BookStorage bookStorage;

    public BookController(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

    public Response addBook(String title, String author) {
        if(bookStorage.isBookAlreadyExist(title, author)) {
            return new Response(false, "Book already exist.");
        }
        bookStorage.add(title, author);
        return new Response(true);
    }
}
