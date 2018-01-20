package pl.sda.ebook.registration;

public class Response {

    private final boolean isSuccess;
    private String message;

    public Response(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Response(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }
}
