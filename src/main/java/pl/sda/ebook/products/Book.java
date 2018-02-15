package pl.sda.ebook.products;

public class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String toJSON() {
        return "{" + "isbn:" + isbn + "," +
                "author:" + author + "," +
                "title:" + title + "}";
    }
}

