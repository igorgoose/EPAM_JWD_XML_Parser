package by.schepov.xmlparser.dispatcher;

import by.schepov.xmlparser.entity.Flower;
import by.schepov.xmlparser.exception.FlowerBuilderException;
import by.schepov.xmlparser.exception.FlowerDispatcherException;

public interface FlowerDispatcher {
    Flower getResult() throws FlowerBuilderException, FlowerDispatcherException;
}
