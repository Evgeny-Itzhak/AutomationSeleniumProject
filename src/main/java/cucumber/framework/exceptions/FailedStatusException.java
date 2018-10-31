package cucumber.framework.exceptions;

public class FailedStatusException extends RuntimeException {
    public FailedStatusException(String message) {
        super(message);
    }
}
