package by.schepov.xmlparser.parser.builder;

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

public class FlowerBuilder {
    private Flower flower;
    private GrowingTipBuilder growingTipBuilder;
    private VisualDescriptionBuilder visualDescriptionBuilder;
    private Pattern ignorePattern = Pattern.compile(XMLNamesRegex.IGNORED_TAG.getRegex());
    private static final int ID_START_INDEX = 2;

    public FlowerBuilder() {
        growingTipBuilder = new GrowingTipBuilder();
        visualDescriptionBuilder = new VisualDescriptionBuilder();
    }


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
                setVisualDescription(node);
                break;
            default:
                throw new FlowerBuilderException("Invalid tag");
        }
    }

    private void createFlower() {
        flower = new Flower();
    }

    private void createPoisonousFlower() {
        flower = new PoisonousFlower();
    }

    private void setID(String id) throws FlowerBuilderException {
        checkFlower();
        flower.setId(Integer.parseInt(id.substring(ID_START_INDEX)));
    }

    private void setName(String name) throws FlowerBuilderException {
        checkFlower();
        flower.setName(name);
    }

    private void setSoil(Soil soil) throws FlowerBuilderException {
        checkFlower();
        flower.setSoilType(soil);
    }

    private void setOrigin(String origin) throws FlowerBuilderException {
        checkFlower();
        flower.setOrigin(origin);
    }

    private void setVisualDescription(VisualDescription visualDescription) throws FlowerBuilderException {
        checkFlower();
        flower.setVisualDescription(visualDescription);
    }

    private void setMultiplyingType(MultiplyingType multiplyingType) throws FlowerBuilderException {
        checkFlower();
        flower.setMultiplyingType(multiplyingType);
    }

    private void setDangerLevel(DangerLevel dangerLevel) throws FlowerBuilderException {
        checkFlower();
        if (flower instanceof PoisonousFlower) {
            ((PoisonousFlower) flower).setDangerLevel(dangerLevel);
            return;
        }
        throw new FlowerBuilderException("Wrong flower type");
    }

    private void setGrowingTip(Node tips) throws FlowerBuilderException {
        checkFlower();
        NodeList tipList = tips.getChildNodes();
        int tipListLength = tipList.getLength();
        growingTipBuilder.createGrowingTip();
        try {
            for (int i = 0; i < tipListLength; i++) {
                Node tip = tipList.item(i);
                Matcher matcher = ignorePattern.matcher(tip.getNodeName());
                if (matcher.matches()) {
                    continue;
                }
                growingTipBuilder.build(tip);
            }
            flower.setGrowingTip(growingTipBuilder.getResult());
        } catch (GrowingTipBuilderException e) {
            throw new FlowerBuilderException(e);
        }
    }

    private void setVisualDescription(Node visualDescriptionNode) throws FlowerBuilderException {
        checkFlower();
        NodeList descriptionList = visualDescriptionNode.getChildNodes();
        int descriptionListLength = descriptionList.getLength();
        visualDescriptionBuilder.createVisualDescription();
        try {
            for (int i = 0; i < descriptionListLength; i++) {
                Node description = descriptionList.item(i);
                Matcher matcher = ignorePattern.matcher(description.getNodeName());
                if (matcher.matches()) {
                    continue;
                }
                visualDescriptionBuilder.build(descriptionList.item(i));
            }
        } catch (VisualDescriptionBuilderException e) {
            throw new FlowerBuilderException(e);
        }
    }

    private void checkFlower() throws FlowerBuilderException {
        if (flower == null) {
            throw new FlowerBuilderException("Flower is not created");
        }
    }

    public Flower getResult() throws FlowerBuilderException {
        if (flower == null) {
            throw new FlowerBuilderException("Flower is not created");
        }
        return flower;
    }
}
