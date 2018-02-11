package pl.sda.ebook.products;

import org.junit.Test;
import org.mockito.BDDMockito;
import pl.sda.ebook.communication.Response;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class BookControllerTest {

    public static final String TITLE = "Wiedzmin";
    public static final String AUTHOR = "Sapkowski";
    public static final String ISBN = "2345656:1233";
    private final BookStorage bookStorage = mock(BookStorage.class);
    private final BookController bookController = new BookController(this.bookStorage);


    @Test
    public void shouldAddBook() {
        Response response = this.bookController.addBook(TITLE, AUTHOR, ISBN);

        assertTrue(response.isSuccess());
        verify(this.bookStorage).add(TITLE, AUTHOR, ISBN);
    }

    @Test
    public void shouldNotAddBookIfBookAlreadyExist() {
        BDDMockito.given(this.bookStorage.isBookAlreadyExist(ISBN)).willReturn(true);

        Response response = this.bookController.addBook(TITLE, AUTHOR, ISBN);

        assertFalse(response.isSuccess());
        verify(this.bookStorage, never()).add(TITLE, AUTHOR, ISBN);
    }

    @Test
    public void shouldReturnInformationAboutExistingBook() {
        BDDMockito.given(this.bookStorage.isBookAlreadyExist(ISBN)).willReturn(true);
        BDDMockito.given(this.bookStorage.searchBy(ISBN)).willReturn(new Book(TITLE, AUTHOR, ISBN));

        Response response = bookController.getInformationAbout(ISBN);

        assertTrue(response.isSuccess());
        assertEquals(anExpectedInformation(ISBN, TITLE, AUTHOR), response.getMessage());
    }

    @Test
    public void shouldNotReturnInformationAboutNotExistingBook() {
        BDDMockito.given(this.bookStorage.isBookAlreadyExist(ISBN)).willReturn(false);

        Response response = bookController.getInformationAbout(ISBN);

        assertFalse(response.isSuccess());
        verify(this.bookStorage, never()).searchBy(ISBN);
    }

    private String anExpectedInformation(String isbn, String title, String author) {
        return "{" + "isbn:" + isbn + ", " +
                "title:" + title + ", " +
                "author:" + author + "}";
    }

}