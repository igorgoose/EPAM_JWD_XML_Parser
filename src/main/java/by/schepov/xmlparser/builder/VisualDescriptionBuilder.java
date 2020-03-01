package by.schepov.xmlparser.builder;

import by.schepov.xmlparser.entity.Colour;
import by.schepov.xmlparser.entity.VisualDescription;
import by.schepov.xmlparser.exception.GrowingTipBuilderException;
import by.schepov.xmlparser.exception.VisualDescriptionBuilderException;

public class VisualDescriptionBuilder {
    private VisualDescription visualDescription;


    public VisualDescriptionBuilder(){

    }

    public void createVisualDescription(){
        visualDescription = new VisualDescription();
    }

    public VisualDescription getResult() {
        return visualDescription;
    }

    public void setAverageSize(int averageSize) throws VisualDescriptionBuilderException {
        checkVisualDescription();
        visualDescription.setAverageSize(averageSize);
    }

    public void setStemColour(Colour stemColour) throws VisualDescriptionBuilderException {
        checkVisualDescription();
        visualDescription.setStemColour(stemColour);
    }

    public void setLeavesColour(Colour leavesColour) throws VisualDescriptionBuilderException {
        checkVisualDescription();
        visualDescription.setLeavesColour(leavesColour);
    }

    public void checkVisualDescription() throws VisualDescriptionBuilderException {
        if(visualDescription == null){
            throw new VisualDescriptionBuilderException("Visual description is not created");
        }
    }
}
