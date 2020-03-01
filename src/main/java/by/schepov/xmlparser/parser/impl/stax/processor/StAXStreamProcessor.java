package by.schepov.xmlparser.parser.impl.stax.processor;

import by.schepov.xmlparser.parser.Tag;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;

public class StAXStreamProcessor implements AutoCloseable {

    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();
    private static final Logger LOGGER = Logger.getLogger(StAXStreamProcessor.class);
    private int currentEvent = -1;
    private final XMLStreamReader reader;

    public StAXStreamProcessor(InputStream is) throws XMLStreamException {
        reader = FACTORY.createXMLStreamReader(is);
    }

    public XMLStreamReader getReader() {
        return reader;
    }

    public boolean doUntil(int stopEvent, String value) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            currentEvent = event;
            if (event == stopEvent && value.equals(reader.getLocalName())) {
                return true;
            }
        }
        return false;
    }

    public boolean startElement(String element, String parent) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            currentEvent = event;
            if (parent != null && event == XMLEvent.END_ELEMENT &&
                    parent.equals(reader.getLocalName())) {
                return false;
            }
            if (event == XMLEvent.START_ELEMENT &&
                    element.equals(reader.getLocalName())) {
                return true;
            }
        }
        return false;
    }

    public boolean endElement(String element) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            currentEvent = event;
            if (event == XMLEvent.END_ELEMENT &&
                    element.equals(reader.getLocalName())) {
                return true;
            }
        }
        return false;
    }

    public Tag endNextElement() throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            currentEvent = event;
            if (event == XMLEvent.END_ELEMENT) {
                return Tag.getTagByValue(reader.getLocalName());
            }
        }
        return Tag.NONE;
    }

    public Tag startNextElement() throws XMLStreamException {
        while (reader.hasNext()){
            int event = reader.next();
            currentEvent = event;
            if(event == XMLEvent.START_ELEMENT){
                return Tag.getTagByValue(reader.getLocalName());
            }
        }
        return Tag.NONE;
    }

    public Tag nextStartOrEndElement() throws XMLStreamException {
        while (reader.hasNext()){
            int event = reader.next();
            currentEvent = event;
            if(event == XMLEvent.START_ELEMENT || event == XMLEvent.END_ELEMENT){
                return Tag.getTagByValue(reader.getLocalName());
            }
        }
        return Tag.NONE;
    }


    public String getAttribute(String name) throws XMLStreamException {
        return reader.getAttributeValue(null, name);
    }

    public String getText() throws XMLStreamException {
        return reader.getElementText();
    }

    public int getCurrentEvent() {
        return currentEvent;
    }

    @Override
    public void close() {
        if (reader != null) {
            try {
                reader.close();
            } catch (XMLStreamException e) {
                LOGGER.error("Resource closing error", e);
            }
        }
    }
}
