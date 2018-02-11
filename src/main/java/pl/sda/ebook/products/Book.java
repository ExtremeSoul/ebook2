package pl.sda.ebook.products;

public class Book  {
    private String name;
    private String author;
    private String isbn;
    private String genre;
    private int yearOfPublishing;
    private String title;

    public Book(String title, String author, String isbn) {

        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }



    public Book(String name, String author, String genre, int yearOfPublishing) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getTitle() {
        return title;
    }
}
