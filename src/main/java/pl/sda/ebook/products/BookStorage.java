package pl.sda.ebook.products;

public interface BookStorage {
    void add(String title, String author, String isbn);

    boolean isBookAlreadyExist(String isbn);

    Book searchBy(String isbn);

    void delete(String isbn);

}
