package by.schepov.xmlparser.main;

import by.schepov.xmlparser.entity.Flower;
import by.schepov.xmlparser.exception.ParserException;
import by.schepov.xmlparser.parser.impl.dom.DOMFlowerParser;
import by.schepov.xmlparser.parser.impl.sax.SAXFlowerParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("______DOM______________________________________");
            DOMFlowerParser parser = new DOMFlowerParser();
            List<Flower> DOMFlowers = parser.parse("xml/flowers.xml");
            for (Flower flower : DOMFlowers) {
                System.out.println(flower);
            }
            System.out.println("______SAX______________________________________");
            SAXFlowerParser saxFlowerParser = new SAXFlowerParser();
            List<Flower> SAXFlowers = saxFlowerParser.parse("xml/flowers.xml");
            for (Flower flower : SAXFlowers) {
                System.out.println(flower);
            }
        } catch (ParserException e) {
            e.printStackTrace();
        }

    }
}
