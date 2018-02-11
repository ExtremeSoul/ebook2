package pl.sda.ebook.communication;

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

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;

    }

    public static Response aSuccessfuleResponse() {
        return new Response(true);
    }
}
