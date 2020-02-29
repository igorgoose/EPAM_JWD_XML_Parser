package by.schepov.xmlparser.entity;

import java.util.Objects;

public class GrowingTip {
    boolean isPhotophilous;
    double growthTemperature;
    int weeklyWatering;

    public GrowingTip(){

    }

    public boolean isPhotophilous() {
        return isPhotophilous;
    }

    public void setPhotophilous(boolean photophilous) {
        isPhotophilous = photophilous;
    }

    public double getGrowthTemperature() {
        return growthTemperature;
    }

    public void setGrowthTemperature(double growthTemperature) {
        this.growthTemperature = growthTemperature;
    }

    public int getWeeklyWatering() {
        return weeklyWatering;
    }

    public void setWeeklyWatering(int weeklyWatering) {
        this.weeklyWatering = weeklyWatering;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrowingTip that = (GrowingTip) o;
        return isPhotophilous == that.isPhotophilous &&
                Double.compare(that.growthTemperature, growthTemperature) == 0 &&
                weeklyWatering == that.weeklyWatering;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isPhotophilous, growthTemperature, weeklyWatering);
    }

    @Override
    public String toString() {
        return "GrowingTip{" +
                "isPhotophilous=" + isPhotophilous +
                ", growthTemperature=" + growthTemperature +
                ", weeklyWatering=" + weeklyWatering +
                '}';
    }
}
