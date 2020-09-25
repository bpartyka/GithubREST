package pl.demo.github.exception;

public class NotFoundResponse {

    private String message;

    public NotFoundResponse(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }

    public void setMessage(String message) {
        this.message = message;
    }
}
