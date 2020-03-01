package by.schepov.xmlparser.parser.impl.stax;

import by.schepov.xmlparser.builder.FlowerBuilder;
import by.schepov.xmlparser.builder.GrowingTipBuilder;
import by.schepov.xmlparser.builder.VisualDescriptionBuilder;
import by.schepov.xmlparser.entity.*;
import by.schepov.xmlparser.exception.FlowerBuilderException;
import by.schepov.xmlparser.exception.GrowingTipBuilderException;
import by.schepov.xmlparser.exception.ParserException;
import by.schepov.xmlparser.exception.VisualDescriptionBuilderException;
import by.schepov.xmlparser.parser.FlowerParser;
import by.schepov.xmlparser.parser.Tag;
import by.schepov.xmlparser.parser.impl.stax.processor.StAXStreamProcessor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StAXFlowerParser implements FlowerParser {

    private StAXStreamProcessor processor;
    private FlowerBuilder flowerBuilder = new FlowerBuilder();
    private GrowingTipBuilder growingTipBuilder = new GrowingTipBuilder();
    private VisualDescriptionBuilder visualDescriptionBuilder = new VisualDescriptionBuilder();
    public static final int ID_INDEX = 2;

    public StAXFlowerParser() {

    }


    @Override
    public List<Flower> parse(String filepath) throws ParserException {
        try {
            processor = new StAXStreamProcessor(new FileInputStream(filepath));
            List<Flower> flowers = new ArrayList<>();
            Tag currentTag;
            String idString;
            String dangerLevel;
            while (!(currentTag = processor.nextStartOrEndElement()).equals(Tag.NONE)) {
                if (processor.getCurrentEvent() == XMLEvent.START_ELEMENT) {
                    switch (currentTag) {
                        case FLOWER:
                            flowerBuilder.createFlower();
                            idString = processor.getAttribute(Tag.ID.getValue()).substring(ID_INDEX);
                            flowerBuilder.setID(Integer.parseInt(idString));
                            break;
                        case POISONOUS_FLOWER:
                            flowerBuilder.createPoisonousFlower();
                            idString = processor.getAttribute(Tag.ID.getValue()).substring(ID_INDEX);
                            flowerBuilder.setID(Integer.parseInt(idString));
                            dangerLevel = processor.getAttribute(Tag.DANGER_LEVEL.getValue());
                            flowerBuilder.setDangerLevel(DangerLevel.getDangerLevelByValue(dangerLevel));
                            break;
                        case SOIL:
                            flowerBuilder.setSoil(Soil.getSoilByValue(processor.getText()));
                            break;
                        case NAME:
                            flowerBuilder.setName(processor.getText());
                            break;
                        case ORIGIN:
                            flowerBuilder.setOrigin(processor.getText());
                            break;
                        case MULTIPLYING:
                            flowerBuilder.setMultiplyingType(MultiplyingType.getMultiplyingTypeByValue(processor.getText()));
                            break;
                        case GROWING_TIPS:
                            growingTipBuilder.createGrowingTip();
                            break;
                        case GROWTH_TEMPERATURE:
                            growingTipBuilder.setGrowthTemperature(Double.parseDouble(processor.getText()));
                            break;
                        case IS_PHOTOPHILOUS:
                            growingTipBuilder.setIsPhotophilous(Boolean.parseBoolean(processor.getText()));
                            break;
                        case WEEKLY_WATERING:
                            growingTipBuilder.setWeeklyWatering(Integer.parseInt(processor.getText()));
                            break;
                        case VISUAL_PARAMETERS:
                            visualDescriptionBuilder.createVisualDescription();
                            break;
                        case STEM_COLOUR:
                            visualDescriptionBuilder.setStemColour(Colour.getColourByValue(processor.getText()));
                            break;
                        case AVERAGE_SIZE:
                            visualDescriptionBuilder.setAverageSize(Integer.parseInt(processor.getText()));
                            break;
                        case LEAVES_COLOUR:
                            visualDescriptionBuilder.setLeavesColour(Colour.getColourByValue(processor.getText()));
                            break;
                    }
                } else {
                    if(currentTag == Tag.FLOWER || currentTag == Tag.POISONOUS_FLOWER){
                        flowerBuilder.setGrowingTip(growingTipBuilder.getResult());
                        flowerBuilder.setVisualDescription(visualDescriptionBuilder.getResult());
                        flowers.add(flowerBuilder.getResult());
                    }
                }
            }
            return flowers;
        } catch (XMLStreamException | FlowerBuilderException | GrowingTipBuilderException | VisualDescriptionBuilderException | FileNotFoundException e) {
            throw new ParserException(e);
        }
    }


}
