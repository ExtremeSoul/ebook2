package pl.sda.ebook.view;

public class SystemInterface implements CliInterface {
    public String readInformation() {
        String recivedInformation = null;
        return recivedInformation;
    }

    public void display(String message) {
        System.out.println(message);
    }
}
