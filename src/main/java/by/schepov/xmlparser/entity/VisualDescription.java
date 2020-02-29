package by.schepov.xmlparser.entity;

import java.util.Objects;

public class VisualDescription {
    private Colour stemColour;
    private Colour leavesColour;
    private int averageSize;

    public VisualDescription(){

    }

    public Colour getStemColour() {
        return stemColour;
    }

    public void setStemColour(Colour stemColour) {
        this.stemColour = stemColour;
    }

    public Colour getLeavesColour() {
        return leavesColour;
    }

    public void setLeavesColour(Colour leavesColour) {
        this.leavesColour = leavesColour;
    }

    public int getAverageSize() {
        return averageSize;
    }

    public void setAverageSize(int averageSize) {
        this.averageSize = averageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisualDescription that = (VisualDescription) o;
        return averageSize == that.averageSize &&
                stemColour == that.stemColour &&
                leavesColour == that.leavesColour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stemColour, leavesColour, averageSize);
    }

    @Override
    public String toString() {
        return "VisualDescription{" +
                "stemColour=" + stemColour +
                ", leavesColour=" + leavesColour +
                ", averageSize=" + averageSize +
                '}';
    }
}
