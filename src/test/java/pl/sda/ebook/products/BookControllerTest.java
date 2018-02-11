package pl.sda.ebook.products;

import org.junit.Test;
import org.mockito.BDDMockito;
import pl.sda.ebook.communication.Response;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class BookControllerTest {

    @Test
    public void shouldAddBook() {
        BookStorage bookStorage = mock(BookStorage.class);
        String title = "Wiedzmin";
        String author = "Sapkowski";
        BookController bookController = new BookController(bookStorage);

        Response response = bookController.addBook(title, author);

        assertTrue(response.isSuccess());
        verify(bookStorage).add(title, author);
    }

    @Test
    public void shouldNotAddBookIfBookAlreadyExist() {
        BookStorage bookStorage = mock(BookStorage.class);
        String title = "Wiedzmin";
        String author = "Sapkowski";
        BookController bookController = new BookController(bookStorage);
        BDDMockito.given(bookStorage.isBookAlreadyExist(title, author)).willReturn(true);

        Response response = bookController.addBook(title, author);

        assertFalse(response.isSuccess());
        verify(bookStorage, never()).add(title, author);


    }

}