package pl.sda.ebook.products;

public class Book  {
    private String name;
    private String author;
    private String genre;
    private int yearOfPublishing;

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
}
