package pl.sda.ebook.products;

public class Book  {
    private String name;
    private String author;
    private String isbn;

    public Book(String name, String author, String isbn) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
    }

    public String toJSON() {
        return "{" + "isbn:" + isbn + ", " +
                "title:" + name + ", " +
                "author:" + author + "}";
    }
}
