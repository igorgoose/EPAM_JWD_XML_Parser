package by.schepov.xmlparser.dispatcher.sax.impl;

import by.schepov.xmlparser.builder.FlowerBuilder;
import by.schepov.xmlparser.builder.GrowingTipBuilder;
import by.schepov.xmlparser.builder.VisualDescriptionBuilder;
import by.schepov.xmlparser.dispatcher.sax.SAXFlowerDispatcher;
import by.schepov.xmlparser.entity.*;
import by.schepov.xmlparser.exception.FlowerBuilderException;
import by.schepov.xmlparser.exception.FlowerDispatcherException;
import by.schepov.xmlparser.exception.GrowingTipBuilderException;
import by.schepov.xmlparser.exception.VisualDescriptionBuilderException;
import by.schepov.xmlparser.parser.Tag;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;


public class SAXFlowerBuilderDispatcher implements SAXFlowerDispatcher {

    private static final Logger LOGGER = Logger.getLogger(SAXFlowerBuilderDispatcher.class);
    private FlowerBuilder flowerBuilder = new FlowerBuilder();
    private GrowingTipBuilder growingTipBuilder = new GrowingTipBuilder();
    private VisualDescriptionBuilder visualDescriptionBuilder = new VisualDescriptionBuilder();
    private static final int ID_INDEX = 2;
    private Tag currentTag = Tag.NONE;

    @Override
    public void rememberTag(Tag tag, Attributes attributes) throws FlowerBuilderException {
        currentTag = tag;
        switch (tag) {
            case FLOWER: {
                flowerBuilder.createFlower();
                String idString = attributes.getValue(Tag.ID.getValue());
                flowerBuilder.setID(Integer.parseInt(idString.substring(ID_INDEX)));
                break;
            }
            case POISONOUS_FLOWER: {
                flowerBuilder.createPoisonousFlower();
                String idString = attributes.getValue(Tag.ID.getValue());
                String dangerLevelString = attributes.getValue(Tag.DANGER_LEVEL.getValue());
                flowerBuilder.setID(Integer.parseInt(idString.substring(ID_INDEX)));
                flowerBuilder.setDangerLevel(DangerLevel.getDangerLevelByValue(dangerLevelString));
                break;
            }
            case GROWING_TIPS:
                growingTipBuilder.createGrowingTip();
                break;
            case VISUAL_PARAMETERS:
                visualDescriptionBuilder.createVisualDescription();
                break;
        }
    }

    @Override
    public void build(String info) throws FlowerDispatcherException {
        try {
            LOGGER.info("tag=" + currentTag + " info=" + info);
            switch (currentTag) {
                case NAME:
                    flowerBuilder.setName(info);
                    break;
                case ORIGIN:
                    flowerBuilder.setOrigin(info);
                    break;
                case SOIL:
                    flowerBuilder.setSoil(Soil.getSoilByValue(info));
                    break;
                case MULTIPLYING:
                    flowerBuilder.setMultiplyingType(MultiplyingType.getMultiplyingTypeByValue(info));
                    break;
                case GROWTH_TEMPERATURE:
                    growingTipBuilder.setGrowthTemperature(Double.parseDouble(info));
                    break;
                case WEEKLY_WATERING:
                    growingTipBuilder.setWeeklyWatering(Integer.parseInt(info));
                    break;
                case IS_PHOTOPHILOUS:
                    growingTipBuilder.setIsPhotophilous(Boolean.parseBoolean(info));
                    break;
                case STEM_COLOUR:
                    visualDescriptionBuilder.setStemColour(Colour.getColourByValue(info));
                    break;
                case LEAVES_COLOUR:
                    visualDescriptionBuilder.setLeavesColour(Colour.getColourByValue(info));
                    break;
                case AVERAGE_SIZE:
                    visualDescriptionBuilder.setAverageSize(Integer.parseInt(info));
                    break;
            }
            currentTag = Tag.NONE;
        } catch (GrowingTipBuilderException | FlowerBuilderException | VisualDescriptionBuilderException e) {
            throw new FlowerDispatcherException(e);
        }
    }

    @Override
    public Flower getResult() throws FlowerDispatcherException {
        try {
            flowerBuilder.setVisualDescription(visualDescriptionBuilder.getResult());
            flowerBuilder.setGrowingTip(growingTipBuilder.getResult());
            return flowerBuilder.getResult();
        } catch (FlowerBuilderException e){
            throw new FlowerDispatcherException(e);
        }
    }
}
