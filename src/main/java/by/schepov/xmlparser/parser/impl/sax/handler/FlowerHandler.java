package by.schepov.xmlparser.parser.impl.sax.handler;

import by.schepov.xmlparser.parser.dispatcher.sax.impl.SAXFlowerBuilderDispatcher;
import by.schepov.xmlparser.parser.dispatcher.sax.SAXFlowerDispatcher;
import by.schepov.xmlparser.entity.Flower;
import by.schepov.xmlparser.exception.FlowerBuilderException;
import by.schepov.xmlparser.exception.FlowerDispatcherException;
import by.schepov.xmlparser.exception.FlowerHandlerException;
import by.schepov.xmlparser.parser.Tag;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class FlowerHandler extends DefaultHandler {

    private static final Logger LOGGER = Logger.getLogger(FlowerHandler.class);
    private SAXFlowerDispatcher dispatcher = new SAXFlowerBuilderDispatcher();
    List<Flower> flowers = new ArrayList<>();

    public FlowerHandler(){

    }

    public FlowerHandler(SAXFlowerDispatcher dispatcher){
        this.dispatcher = dispatcher;
    }

    @Override
    public void startDocument() throws SAXException {
        LOGGER.info("start document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws FlowerHandlerException {
        LOGGER.info("START ELEMENT <" + qName + ">");
        try {
            dispatcher.rememberTag(Tag.getTagByValue(qName), attributes);
        } catch (FlowerBuilderException | FlowerDispatcherException e) {
            throw new FlowerHandlerException(e);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        LOGGER.info("END ELEMENT <" + qName + ">");
        if(qName.equals(Tag.FLOWER.getValue()) || qName.equals(Tag.POISONOUS_FLOWER.getValue())){
            try {
                flowers.add(dispatcher.getResult());
            } catch (FlowerDispatcherException e) {
                throw new FlowerHandlerException(e);
            }
        }
    }

    @Override
    public void endDocument() throws SAXException {
        LOGGER.info("end document");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws FlowerHandlerException {
        try {
            dispatcher.build(new String(ch, start, length));
        } catch (FlowerBuilderException | FlowerDispatcherException e) {
            throw new FlowerHandlerException(e);
        }
    }

    public List<Flower> getFlowers(){
        return flowers;
    }
}
