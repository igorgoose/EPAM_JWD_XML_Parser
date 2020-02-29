package by.schepov.xmlparser.entity;

public enum Soil {
    HUMUS("humus"),
    PODZOLIC("podzolic"),
    SOD_PODZOLIC("sod-podzolic"),
    GROUND("ground");

    String value;

    Soil(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Soil getSoilByValue(String value) {
        Soil[] values = Soil.values();
        for (Soil soil : values) {
            if(soil.value.equals(value)){
                return soil;
            }
        }
        throw new IllegalArgumentException();
    }
}
