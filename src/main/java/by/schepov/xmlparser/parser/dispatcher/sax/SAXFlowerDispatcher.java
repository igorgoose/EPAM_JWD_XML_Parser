package by.schepov.xmlparser.parser.dispatcher.sax;

import by.schepov.xmlparser.parser.dispatcher.FlowerDispatcher;
import by.schepov.xmlparser.entity.Flower;
import by.schepov.xmlparser.exception.FlowerBuilderException;
import by.schepov.xmlparser.exception.FlowerDispatcherException;
import by.schepov.xmlparser.parser.Tag;

import org.xml.sax.Attributes;

public interface SAXFlowerDispatcher extends FlowerDispatcher {
    void rememberTag(Tag tag, Attributes attributes) throws FlowerBuilderException, FlowerDispatcherException;
    void build(String info) throws FlowerBuilderException, FlowerDispatcherException;
    Flower getResult() throws FlowerDispatcherException;
}
