package by.schepov.xmlparser.exception;

public class XMLValidatorException extends Exception {
    public XMLValidatorException() {
    }

    public XMLValidatorException(String message) {
        super(message);
    }

    public XMLValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLValidatorException(Throwable cause) {
        super(cause);
    }
}
