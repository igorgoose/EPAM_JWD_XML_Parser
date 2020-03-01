package by.schepov.xmlparser.dispatcher.dom.impl;

import by.schepov.xmlparser.builder.FlowerBuilder;
import by.schepov.xmlparser.dispatcher.dom.DOMFlowerDispatcher;
import by.schepov.xmlparser.dispatcher.dom.DOMGrowingTipBuilderDispatcher;
import by.schepov.xmlparser.dispatcher.dom.DOMVisualDescriptionBuilderDispatcher;
import by.schepov.xmlparser.entity.*;
import by.schepov.xmlparser.exception.FlowerBuilderException;
import by.schepov.xmlparser.exception.GrowingTipBuilderException;
import by.schepov.xmlparser.exception.VisualDescriptionBuilderException;
import by.schepov.xmlparser.parser.Tag;
import by.schepov.xmlparser.parser.XMLNamesRegex;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.schepov.xmlparser.parser.Tag.*;

public class DOMFlowerBuilderDispatcher implements DOMFlowerDispatcher {
    private FlowerBuilder flowerBuilder = new FlowerBuilder();
    private DOMGrowingTipBuilderDispatcher growingTipBuilderDispatcher = new DOMGrowingTipBuilderDispatcher();
    private DOMVisualDescriptionBuilderDispatcher visualDescriptionBuilderDispatcher = new DOMVisualDescriptionBuilderDispatcher();
    private Pattern ignorePattern = Pattern.compile(XMLNamesRegex.IGNORED_TAG.getRegex());
    private static final int ID_START_INDEX = 2;

    public DOMFlowerBuilderDispatcher() {
    }

    @Override
    public void build(Node node) throws FlowerBuilderException {
        Tag tag = Tag.getTagByValue(node.getNodeName());
        switch (tag) {
            case POISONOUS_FLOWER:
                createPoisonousFlower();
                setDangerLevel(DangerLevel.getDangerLevelByValue(node.getAttributes().getNamedItem(DANGER_LEVEL.getValue()).getTextContent()));
                setID(node.getAttributes().getNamedItem(ID.getValue()).getTextContent());
                break;
            case FLOWER:
                createFlower();
                setID(node.getAttributes().getNamedItem(ID.getValue()).getTextContent());
                break;
            case NAME:
                setName(node.getTextContent());
                break;
            case SOIL:
                setSoil(Soil.getSoilByValue(node.getTextContent()));
                break;
            case ORIGIN:
                setOrigin(node.getTextContent());
                break;
            case MULTIPLYING:
                setMultiplyingType(MultiplyingType.getMultiplyingTypeByValue(node.getTextContent()));
                break;
            case GROWING_TIPS:
                setGrowingTip(node);
                break;
            case VISUAL_PARAMETERS:
                createVisualDescription(node);
                break;
            default:
                throw new FlowerBuilderException("Invalid tag");
        }
    }

    private void createFlower() {
        flowerBuilder.createFlower();
    }

    private void createPoisonousFlower() {
        flowerBuilder.createPoisonousFlower();
    }

    private void setID(String id) throws FlowerBuilderException {
        flowerBuilder.setID(Integer.parseInt(id.substring(ID_START_INDEX)));
    }

    private void setName(String name) throws FlowerBuilderException {
        flowerBuilder.setName(name);
    }

    private void setSoil(Soil soil) throws FlowerBuilderException {
        flowerBuilder.setSoil(soil);
    }

    private void setOrigin(String origin) throws FlowerBuilderException {
        flowerBuilder.setOrigin(origin);
    }

    private void createVisualDescription(VisualDescription visualDescription) throws FlowerBuilderException {
        flowerBuilder.setVisualDescription(visualDescription);
    }

    private void setMultiplyingType(MultiplyingType multiplyingType) throws FlowerBuilderException {
        flowerBuilder.setMultiplyingType(multiplyingType);
    }

    private void setDangerLevel(DangerLevel dangerLevel) throws FlowerBuilderException {
        flowerBuilder.setDangerLevel(dangerLevel);
    }

    private void setGrowingTip(Node tips) throws FlowerBuilderException {
        NodeList tipList = tips.getChildNodes();
        int tipListLength = tipList.getLength();
        growingTipBuilderDispatcher.createGrowingTip();
        try {
            for (int i = 0; i < tipListLength; i++) {
                Node tip = tipList.item(i);
                Matcher matcher = ignorePattern.matcher(tip.getNodeName());
                if (matcher.matches()) {
                    continue;
                }
                growingTipBuilderDispatcher.build(tip);
            }
            flowerBuilder.setGrowingTip(growingTipBuilderDispatcher.getResult());
        } catch (GrowingTipBuilderException e) {
            throw new FlowerBuilderException(e);
        }
    }

    private void createVisualDescription(Node visualDescriptionNode) throws FlowerBuilderException {
        NodeList descriptionList = visualDescriptionNode.getChildNodes();
        int descriptionListLength = descriptionList.getLength();
        visualDescriptionBuilderDispatcher.createVisualDescription();
        try {
            for (int i = 0; i < descriptionListLength; i++) {
                Node description = descriptionList.item(i);
                Matcher matcher = ignorePattern.matcher(description.getNodeName());
                if (matcher.matches()) {
                    continue;
                }
                visualDescriptionBuilderDispatcher.build(descriptionList.item(i));
            }
            flowerBuilder.setVisualDescription(visualDescriptionBuilderDispatcher.getResult());
        } catch (VisualDescriptionBuilderException e) {
            throw new FlowerBuilderException(e);
        }
    }

    @Override
    public Flower getResult() throws FlowerBuilderException {
        return flowerBuilder.getResult();
    }
}
