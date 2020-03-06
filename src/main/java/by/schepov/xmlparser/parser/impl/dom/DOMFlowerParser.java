package by.schepov.xmlparser.parser.impl.dom;

import by.schepov.xmlparser.parser.dispatcher.dom.DOMFlowerDispatcher;
import by.schepov.xmlparser.parser.XMLNamesRegex;
import by.schepov.xmlparser.entity.Flower;
import by.schepov.xmlparser.exception.FlowerBuilderException;
import by.schepov.xmlparser.exception.ParserException;
import by.schepov.xmlparser.parser.FlowerParser;
import by.schepov.xmlparser.parser.dispatcher.dom.impl.DOMFlowerBuilderDispatcher;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DOMFlowerParser implements FlowerParser {

    private static final DocumentBuilderFactory DOCUMENT_BUILDER_FACTORY = DocumentBuilderFactory.newInstance();
    private DocumentBuilder documentBuilder;
    private DOMFlowerDispatcher dispatcher;
    Pattern ignorePattern = Pattern.compile(XMLNamesRegex.IGNORED_TAG.getRegex());

    public DOMFlowerParser() throws ParserException {
        try {
            documentBuilder = DOCUMENT_BUILDER_FACTORY.newDocumentBuilder();
            dispatcher = new DOMFlowerBuilderDispatcher();
        } catch (ParserConfigurationException e) {
            throw new ParserException(e);
        }
    }

    public DOMFlowerParser(DOMFlowerDispatcher dispatcher) throws ParserException {
        this.dispatcher = dispatcher;
        try {
            documentBuilder = DOCUMENT_BUILDER_FACTORY.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new ParserException(e);
        }
    }

    @Override
    public List<Flower> parse(InputStream inputStream) throws ParserException {
        try {
            Document document = documentBuilder.parse(inputStream);
            ArrayList<Flower> flowers = new ArrayList<>();
            Node flowerNode;
            Element root = document.getDocumentElement();

            NodeList flowerNodeList = root.getChildNodes();
            int flowerNodeListLength = flowerNodeList.getLength();
            for (int i = 0; i < flowerNodeListLength; i++) {
                flowerNode = flowerNodeList.item(i);
                if(isIrrelevantTag(flowerNode)) {
                    continue;
                }

                dispatcher.build(flowerNode);
                NodeList fieldNodes = flowerNode.getChildNodes();
                int fieldNodesLength = fieldNodes.getLength();
                for (int j = 0; j < fieldNodesLength; j++) {
                    Node currentFieldNode = fieldNodes.item(j);
                    if(isIrrelevantTag(currentFieldNode)){
                        continue;
                    }
                    dispatcher.build(currentFieldNode);
                }
                flowers.add(dispatcher.getResult());
            }
            return flowers;
        } catch (SAXException | IOException | FlowerBuilderException e) {
            throw new ParserException(e);
        }
    }

    boolean isIrrelevantTag(Node node){
        return ignorePattern.matcher(node.getNodeName()).matches();
    }
}
