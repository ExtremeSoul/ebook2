package pl.sda.ebook.products;

import pl.sda.ebook.communication.Response;
import pl.sda.ebook.domain.EBooksStorage;

public class BookController {
    private EBooksStorage booksStorage;

    public BookController(EBooksStorage booksStorage) {

        this.booksStorage = booksStorage;
    }

    public Response addBook(String title, String author, String isbn) {
        booksStorage.addBook(title, author, isbn);
        return new Response(true);
    }

    public Response getInformationAbout(String isbn) {
        Response response = Response.aSuccessfuleResponse();
        Book book = booksStorage.searchBy(isbn);
        response.setMessage("{" +
                "title:" + book.getTitle() + "," +
                "author:" + book.getAuthor() + "," +
                "isbn:" + isbn + "," +
                "}");
        return response;
    }
}
