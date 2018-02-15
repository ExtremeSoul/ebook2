package pl.sda.ebook.products;

import pl.sda.ebook.communication.Response;

public class BookController {
    private final BookStorage bookStorage;

    public BookController(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

    public Response addBook(String title, String author, String isbn) {
        if (bookStorage.isBookAlreadyExist(isbn)) {
            return new Response(false, "Book already exist.");
        }
        bookStorage.add(title, author, isbn);
        return new Response(true);
    }

    public Response getInformationAbout(String isbn) {
        if (bookStorage.isBookAlreadyExist(isbn)) {
            Book book = bookStorage.searchBy(isbn);
            return new Response(true, book.toJSON());
        }
        return new Response(false, "Book already exist.");
    }

    public Response deleteBook(String isbn) {
        if (bookStorage.isBookAlreadyExist(isbn)) {
            bookStorage.delete(isbn);
            return new Response(true);
        }
        return new Response(false, "Book not exist");
    }
}
