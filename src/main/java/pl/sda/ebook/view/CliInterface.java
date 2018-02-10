package pl.sda.ebook.view;

public interface CliInterface {
    default String readInformation() {
        return null;
    }

    default void display(String message) {

    }
}
