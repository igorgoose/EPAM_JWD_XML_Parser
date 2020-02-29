package by.schepov.xmlparser.entity;

import java.util.Objects;

public class PoisonousFlower extends Flower{
    protected DangerLevel dangerLevel;

    public DangerLevel getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(DangerLevel dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PoisonousFlower that = (PoisonousFlower) o;
        return dangerLevel == that.dangerLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dangerLevel);
    }

    @Override
    public String toString() {
        return "PoisonousFlower{" +
                "dangerLevel=" + dangerLevel +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", soilType=" + soilType +
                ", origin='" + origin + '\'' +
                ", visualDescription=" + visualDescription +
                ", growingTip=" + growingTip +
                ", multiplyingType=" + multiplyingType +
                ", wildOnly=" + wildOnly +
                '}';
    }
}
