package by.schepov.xmlparser.parser;

import by.schepov.xmlparser.entity.Flower;
import by.schepov.xmlparser.exception.ParserException;

import java.util.List;

public interface FlowerParser {
    List<Flower> parse(String filepath) throws ParserException;
}
