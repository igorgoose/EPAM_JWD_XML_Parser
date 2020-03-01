package by.schepov.xmlparser.builder;

import by.schepov.xmlparser.entity.*;

import by.schepov.xmlparser.exception.FlowerBuilderException;


public class FlowerBuilder {
    private Flower flower;

    public FlowerBuilder(){

    }

    public void createFlower() {
        flower = new Flower();
    }

    public void createPoisonousFlower() {
        flower = new PoisonousFlower();
    }

    public void setID(int id) throws FlowerBuilderException {
        checkFlower();
        flower.setId(id);
    }

    public void setName(String name) throws FlowerBuilderException {
        checkFlower();
        flower.setName(name);
    }

    public void setSoil(Soil soil) throws FlowerBuilderException {
        checkFlower();
        flower.setSoilType(soil);
    }

    public void setOrigin(String origin) throws FlowerBuilderException {
        checkFlower();
        flower.setOrigin(origin);
    }

    public void setVisualDescription(VisualDescription visualDescription) throws FlowerBuilderException {
        checkFlower();
        flower.setVisualDescription(visualDescription);
    }

    public void setMultiplyingType(MultiplyingType multiplyingType) throws FlowerBuilderException {
        checkFlower();
        flower.setMultiplyingType(multiplyingType);
    }

    public void setDangerLevel(DangerLevel dangerLevel) throws FlowerBuilderException {
        checkFlower();
        if (flower instanceof PoisonousFlower) {
            ((PoisonousFlower) flower).setDangerLevel(dangerLevel);
            return;
        }
        throw new FlowerBuilderException("Wrong flower type");
    }

    public void setGrowingTip(GrowingTip growingTip) throws FlowerBuilderException {
        checkFlower();
        flower.setGrowingTip(growingTip);
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
