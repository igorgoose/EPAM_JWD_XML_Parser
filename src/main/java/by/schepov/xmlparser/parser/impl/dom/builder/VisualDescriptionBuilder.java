package by.schepov.xmlparser.parser.builder;

import by.schepov.xmlparser.entity.Colour;
import by.schepov.xmlparser.entity.VisualDescription;
import by.schepov.xmlparser.exception.VisualDescriptionBuilderException;
import by.schepov.xmlparser.parser.Tag;
import org.w3c.dom.Node;

public class VisualDescriptionBuilder {
    VisualDescription visualDescription;

    public VisualDescriptionBuilder() {

    }

    public void createVisualDescription() {
        visualDescription = new VisualDescription();
    }

    public void build(Node node) throws VisualDescriptionBuilderException {
        Tag tag = Tag.getTagByValue(node.getNodeName());
        String content = node.getTextContent();
        switch (tag) {
            case LEAVES_COLOUR:
                setLeavesColour(Colour.getColourByValue(content));
                break;
            case STEM_COLOUR:
                setStemColour(Colour.getColourByValue(content));
                break;
            case AVERAGE_SIZE:
                setAverageSize(Integer.parseInt(content));
                break;
            default:
                throw new VisualDescriptionBuilderException("Invalid tag");
        }
    }

    public VisualDescription getResult() {
        return visualDescription;
    }

    private void setLeavesColour(Colour leavesColour) throws VisualDescriptionBuilderException {
        checkGrowingTip();
        visualDescription.setLeavesColour(leavesColour);
    }

    private void setStemColour(Colour stemColour) throws VisualDescriptionBuilderException {
        checkGrowingTip();
        visualDescription.setStemColour(stemColour);
    }

    private void setAverageSize(int averageSize) throws VisualDescriptionBuilderException {
        checkGrowingTip();
        visualDescription.setAverageSize(averageSize);
    }

    private void checkGrowingTip() throws VisualDescriptionBuilderException {
        if (visualDescription == null) {
            throw new VisualDescriptionBuilderException("Visual description is not created");
        }
    }
}
