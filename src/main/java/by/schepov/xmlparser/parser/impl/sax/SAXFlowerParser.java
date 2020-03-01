package by.schepov.xmlparser.parser.impl.sax;

import by.schepov.xmlparser.entity.Flower;
import by.schepov.xmlparser.exception.ParserException;
import by.schepov.xmlparser.parser.FlowerParser;
import by.schepov.xmlparser.parser.impl.sax.handler.FlowerHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SAXFlowerParser implements FlowerParser {

    private SAXParser parser;
    private FlowerHandler handler = new FlowerHandler();

    public SAXFlowerParser() throws ParserException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            throw new ParserException(e);
        }
    }

    @Override
    public List<Flower> parse(String filepath) throws ParserException {
        try {
            parser.parse(filepath, handler);
            return handler.getFlowers();
        } catch (SAXException | IOException e) {
            throw new ParserException(e);
        }
    }
}
