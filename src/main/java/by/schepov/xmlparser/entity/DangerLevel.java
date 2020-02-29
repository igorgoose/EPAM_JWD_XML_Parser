package by.schepov.xmlparser.entity;

public enum DangerLevel {
    HIGH("high"),
    MEDIUM("medium"),
    LOW("low");

    private String value;

    DangerLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DangerLevel getDangerLevelByValue(String value) {
        DangerLevel[] values = DangerLevel.values();
        for (DangerLevel dangerLevel : values) {
            if (dangerLevel.value.equals(value)) {
                return dangerLevel;
            }
        }
        throw new IllegalArgumentException();
    }
}
