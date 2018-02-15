package pl.sda.ebook.products;

import java.io.*;

public class FileBooksStorage implements BookStorage {

    private String pathFileName;

    public FileBooksStorage(String pathFileName) {
        this.pathFileName = pathFileName;
    }

    @Override
    public boolean isBookAlreadyExist(String isbn) {
        return false;
    }

    @Override
    public void add(String title, String author, String isbn) {
        Book book = new Book(title, author, isbn);

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            fileWriter = new FileWriter(new File(pathFileName), true);
            bufferedWriter.write(book.toJSON());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book searchBy(String isbn) {
        return null;
    }

    @Override
    public void delete(String isbn) {

    }


    //    public void downloadBooksDatabase() {
//        Scanner scanner = new Scanner(booksWriter.getBooksDatabse());
//        while (scanner.hasNextLine()) {
//            String name = null;
//            String author = null;
//            String isbn = null;
//            String line = scanner.nextLine();
//            String[] parts = line.split(";");
//            parts[0] = name;
//            parts[1] = author;
//            parts[2] = isbn;
//            int year = Integer.parseInt(yearOfPublishing);
//            Book book = new Book(name, author, isbn);
//        }
//    }

}
