package exceptions;

public class KeyAlreadyExistsException extends RuntimeException {
    public KeyAlreadyExistsException() {
    }

    public KeyAlreadyExistsException(String message) {
        super(message);
    }
}
