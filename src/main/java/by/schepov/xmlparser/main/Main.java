package by.schepov.xmlparser.main;

import by.schepov.xmlparser.entity.Flower;
import by.schepov.xmlparser.exception.ParserException;
import by.schepov.xmlparser.parser.impl.DOMFlowerParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            DOMFlowerParser parser = new DOMFlowerParser();
            List<Flower> flowers = parser.parse("xml/flowers.xml");
            for (Flower flower : flowers) {
                System.out.println(flower);
            }
        } catch (ParserException e) {
            e.printStackTrace();
        }

    }
}
