package by.schepov.xmlparser.exception;

public class ParserServiceException extends Exception {
    public ParserServiceException() {
    }

    public ParserServiceException(String message) {
        super(message);
    }

    public ParserServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParserServiceException(Throwable cause) {
        super(cause);
    }
}
