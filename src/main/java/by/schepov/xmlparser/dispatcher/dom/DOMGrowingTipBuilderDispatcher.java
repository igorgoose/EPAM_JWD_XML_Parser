package by.schepov.xmlparser.dispatcher.dom;

import by.schepov.xmlparser.entity.GrowingTip;
import by.schepov.xmlparser.exception.GrowingTipBuilderException;
import by.schepov.xmlparser.parser.Tag;
import org.w3c.dom.Node;

public class DOMGrowingTipBuilderDispatcher {
    private GrowingTip growingTip;

    public DOMGrowingTipBuilderDispatcher(){

    }

    public void createGrowingTip(){
        growingTip = new GrowingTip();
    }

    public void build(Node node) throws GrowingTipBuilderException {
        Tag tag = Tag.getTagByValue(node.getNodeName());
        switch (tag){
            case WEEKLY_WATERING:
                setWeeklyWatering(Integer.parseInt(node.getTextContent()));
                break;
            case GROWTH_TEMPERATURE:
                setGrowthTemperature(Double.parseDouble(node.getTextContent()));
                break;
            case IS_PHOTOPHILOUS:
                setIsPhotophilous(Boolean.parseBoolean(node.getTextContent()));
                break;
            default:
                throw new GrowingTipBuilderException("Invalid tag");
        }
    }

    public GrowingTip getResult(){
        return growingTip;
    }

    private void setIsPhotophilous(boolean isPhotophilous) throws GrowingTipBuilderException {
        checkGrowingTip();
        growingTip.setPhotophilous(isPhotophilous);
    }

    private void setWeeklyWatering(int weeklyWatering) throws GrowingTipBuilderException {
        checkGrowingTip();
        growingTip.setWeeklyWatering(weeklyWatering);
    }

    private void setGrowthTemperature(double growthTemperature) throws GrowingTipBuilderException {
        checkGrowingTip();
        growingTip.setGrowthTemperature(growthTemperature);
    }

    private void checkGrowingTip() throws GrowingTipBuilderException {
        if(growingTip == null){
            throw new GrowingTipBuilderException("Growing tip is not created");
        }
    }
}
