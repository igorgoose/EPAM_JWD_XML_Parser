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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class Main {
    private final static String file = "xml/flowers.xml";
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            System.out.println("______DOM______________________________________");
            DOMFlowerParser parser = new DOMFlowerParser();
            List<Flower> DOMFlowers = parser.parse(file);
            for (Flower flower : DOMFlowers) {
                System.out.println(flower);
            }
            System.out.println("______SAX______________________________________");
            SAXFlowerParser saxFlowerParser = new SAXFlowerParser();
            List<Flower> SAXFlowers = saxFlowerParser.parse(file);
            for (Flower flower : SAXFlowers) {
                System.out.println(flower);
            }
//            InputStream is = new FileInputStream("xml/flowers.xml");
//            XMLStreamReader reader = XMLInputFactory.newFactory().createXMLStreamReader(is);
//            while(reader.hasNext()){
//                int event = reader.next();
//                if(event == XMLStreamReader.START_ELEMENT) {
//                    System.out.println(reader.getLocalName());
//                }
//            }
            System.out.println("______StAX______________________________________");
            StAXFlowerParser stAXFlowerParser = new StAXFlowerParser();
            List<Flower> staxFlowers = stAXFlowerParser.parse(file);
            for (Flower flower : staxFlowers) {
                System.out.println(flower);
            }
        } catch (ParserException e) {
            LOGGER.error(e);
        }

    }
}
