package by.schepov.xmlparser.exception;

import org.xml.sax.SAXException;

public class FlowerHandlerException extends SAXException {
    public FlowerHandlerException() {
    }

    public FlowerHandlerException(String message) {
        super(message);
    }

    public FlowerHandlerException(Exception e) {
        super(e);
    }

    public FlowerHandlerException(String message, Exception e) {
        super(message, e);
    }
}
