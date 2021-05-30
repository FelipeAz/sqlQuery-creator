package src.app.domain.query.exception;

public class MissingRequiredField extends Exception {
    public MissingRequiredField(String message) {
        super(message);
    }
}
