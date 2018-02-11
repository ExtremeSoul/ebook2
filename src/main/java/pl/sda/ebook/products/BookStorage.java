package pl.sda.ebook.products;

public interface BookStorage {
    void add(String title, String author);

    boolean isBookAlreadyExist(String title, String author);

}
