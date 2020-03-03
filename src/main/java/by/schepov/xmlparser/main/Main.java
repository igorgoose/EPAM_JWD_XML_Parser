package by.schepov.xmlparser.main;

import by.schepov.xmlparser.entity.Flower;
import by.schepov.xmlparser.exception.ParserException;
import by.schepov.xmlparser.parser.impl.dom.DOMFlowerParser;
import by.schepov.xmlparser.parser.impl.sax.SAXFlowerParser;
import by.schepov.xmlparser.parser.impl.stax.StAXFlowerParser;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

public class Main {
    private static final File file = new File(Objects.requireNonNull(Main.class.getClassLoader().getResource("flowers.xml")).getFile());
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            System.out.println("______DOM______________________________________");
            DOMFlowerParser parser = new DOMFlowerParser();
            List<Flower> DOMFlowers = parser.parse(file.getPath());
            for (Flower flower : DOMFlowers) {
                System.out.println(flower);
            }
            System.out.println("______SAX______________________________________");
            SAXFlowerParser saxFlowerParser = new SAXFlowerParser();
            List<Flower> SAXFlowers = saxFlowerParser.parse(file.getPath());
            for (Flower flower : SAXFlowers) {
                System.out.println(flower);
            }
            System.out.println("______StAX______________________________________");
            StAXFlowerParser stAXFlowerParser = new StAXFlowerParser();
            List<Flower> staxFlowers = stAXFlowerParser.parse(file.getPath());
            for (Flower flower : staxFlowers) {
                System.out.println(flower);
            }
        } catch (ParserException e) {
            LOGGER.error(e);
        }

    }
}
