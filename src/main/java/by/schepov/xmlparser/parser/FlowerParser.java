package by.schepov.xmlparser.parser;

import by.schepov.xmlparser.entity.Flower;
import by.schepov.xmlparser.exception.ParserException;

import java.io.InputStream;
import java.util.List;

public interface FlowerParser {
    List<Flower> parse(InputStream inputStream) throws ParserException;
}
