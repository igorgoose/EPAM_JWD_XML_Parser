package by.schepov.xmlparser.builder;

import by.schepov.xmlparser.entity.GrowingTip;
import by.schepov.xmlparser.exception.GrowingTipBuilderException;

public class GrowingTipBuilder {
    private GrowingTip growingTip;

    public GrowingTipBuilder(){

    }

    public void createGrowingTip(){
        growingTip = new GrowingTip();
    }

    public GrowingTip getResult() {
        return growingTip;
    }

    public void setIsPhotophilous(boolean isPhotophilous) throws GrowingTipBuilderException {
        checkGrowingTip();
        growingTip.setPhotophilous(isPhotophilous);
    }

    public void setGrowthTemperature(double growthTemperature) throws GrowingTipBuilderException {
        checkGrowingTip();
        growingTip.setGrowthTemperature(growthTemperature);
    }

    public void setWeeklyWatering(int weeklyWatering) throws GrowingTipBuilderException {
        checkGrowingTip();
        growingTip.setWeeklyWatering(weeklyWatering);
    }

    public void checkGrowingTip() throws GrowingTipBuilderException {
        if(growingTip == null){
            throw new GrowingTipBuilderException();
        }
    }
}
