package by.schepov.xmlparser.parser.impl;

import by.schepov.xmlparser.parser.XMLNamesRegex;
import by.schepov.xmlparser.parser.builder.FlowerBuilder;
import by.schepov.xmlparser.entity.Flower;
import by.schepov.xmlparser.exception.FlowerBuilderException;
import by.schepov.xmlparser.exception.ParserException;
import by.schepov.xmlparser.parser.FlowerParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DOMFlowerParser implements FlowerParser {


    private DocumentBuilderFactory documentBuilderFactory;
    private DocumentBuilder documentBuilder;
    private FlowerBuilder flowerBuilder;
    Pattern ignorePattern = Pattern.compile(XMLNamesRegex.IGNORED_TAG.getRegex());

    public DOMFlowerParser() throws ParserException {
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            flowerBuilder = new FlowerBuilder();
        } catch (ParserConfigurationException e) {
            throw new ParserException(e);
        }
    }

    @Override
    public List<Flower> parse(String filepath) throws ParserException {
        try {
            Document document = documentBuilder.parse(filepath);
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

                flowerBuilder.build(flowerNode);
                NodeList fieldNodes = flowerNode.getChildNodes();
                int fieldNodesLength = fieldNodes.getLength();
                for (int j = 0; j < fieldNodesLength; j++) {
                    Node currentFieldNode = fieldNodes.item(j);
                    if(isIrrelevantTag(currentFieldNode)){
                        continue;
                    }
                    flowerBuilder.build(currentFieldNode);
                }
                flowers.add(flowerBuilder.getResult());
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
