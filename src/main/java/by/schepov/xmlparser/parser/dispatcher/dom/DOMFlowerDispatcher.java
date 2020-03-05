package by.schepov.xmlparser.parser.dispatcher.dom;


import by.schepov.xmlparser.parser.dispatcher.FlowerDispatcher;
import by.schepov.xmlparser.entity.Flower;
import by.schepov.xmlparser.exception.FlowerBuilderException;
import org.w3c.dom.Node;

public interface DOMFlowerDispatcher extends FlowerDispatcher {
    void build(Node node) throws FlowerBuilderException;
    Flower getResult() throws FlowerBuilderException;
}
