package by.schepov.xmlparser.entity;

import java.util.Objects;

public class GrowingTip {
    private boolean photophilous;
    private double growthTemperature;
    private int weeklyWatering;

    public GrowingTip(){

    }

    public boolean isPhotophilous() {
        return photophilous;
    }

    public void setPhotophilous(boolean photophilous) {
        this.photophilous = photophilous;
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
        return photophilous == that.photophilous &&
                Double.compare(that.growthTemperature, growthTemperature) == 0 &&
                weeklyWatering == that.weeklyWatering;
    }

    @Override
    public int hashCode() {
        return Objects.hash(photophilous, growthTemperature, weeklyWatering);
    }

    @Override
    public String toString() {
        return "GrowingTip{" +
                "isPhotophilous=" + photophilous +
                ", growthTemperature=" + growthTemperature +
                ", weeklyWatering=" + weeklyWatering +
                '}';
    }
}
