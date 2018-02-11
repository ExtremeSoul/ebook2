package pl.sda.ebook.products;

import org.junit.Test;
import org.mockito.BDDMockito;
import pl.sda.ebook.communication.Response;
import pl.sda.ebook.domain.EBooksStorage;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookControllerTest {

    @Test
    public void shouldAddBook() {

        EBooksStorage booksStorage = mock(EBooksStorage.class);
        String title = "Kamasutra";
        String author = "Vatsyayana";
        String isbn = "09:33:09";
        BookController bookController = new BookController(booksStorage);

        Response response = bookController.addBook(title, author, isbn);

        assertTrue(response.isSuccess());
        verify(booksStorage).addBook(title, author, isbn);
    }

    @Test
    public void shouldReturnInformationAboutExistingBook() {
        String title = "Kamasutra";
        String author = "Vatsyayana";
        String isbn = "09:33:09";

        EBooksStorage booksStorage = mock(EBooksStorage.class);
        BookController bookController = new BookController(booksStorage);

        given(booksStorage.searchBy(isbn)).willReturn(new Book(title, author, isbn));
        Response response = bookController.getInformationAbout(isbn);

         assertTrue(response.isSuccess());
         assertEquals(anExpectedInformation(title, author, isbn), response.getMessage());
    }

    private String anExpectedInformation(String title, String author, String isbn) {
        return "{" +
                "title:" + title + "," +
                "author:" + author + "," +
                "isbn:" + isbn + "," +
                "}";

    }
}