package pl.sda.ebook.products;

import org.junit.Test;
import pl.sda.ebook.communication.Response;
import pl.sda.ebook.domain.EBooksStorage;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookControlerTest {

    @Test
    public void shouldAddBook() {
        EBooksStorage booksStorage = mock(EBooksStorage.class);
        String title = "Kamasutra";
        String author = "Vatsyayana";
        BookController bookController = new BookController(booksStorage);

        Response response = bookController.addBook(title, author);

        assertTrue(response.isSuccess());
        verify(booksStorage).addBook(title, author);
    }
}