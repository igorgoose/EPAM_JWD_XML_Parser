package by.schepov.xmlparser.parser.impl;

import by.schepov.xmlparser.entity.Flower;
import by.schepov.xmlparser.parser.FlowerParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

public class SAXFlowerParser extends DefaultHandler implements FlowerParser {

    private String 
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public List<Flower> parse(String filepath) {
        return null;
    }
}
