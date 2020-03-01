package by.schepov.xmlparser.parser;

public enum Tag {
    FLOWER("flower"),
    POISONOUS_FLOWER("poisonous_flower"),
    FLOWERS("flowers"),

    NAME("name"),
    SOIL("soil"),
    ORIGIN("origin"),
    VISUAL_PARAMETERS("visual_parameters"),
    GROWING_TIPS("growing_tips"),
    MULTIPLYING("multiplying"),

    GROWTH_TEMPERATURE("growth_temperature"),
    WEEKLY_WATERING("weekly_watering"),
    IS_PHOTOPHILOUS("is_photophilous"),


    LEAVES_COLOUR("leaves_colour"),
    STEM_COLOUR("stem_colour"),
    AVERAGE_SIZE("average_size"),

    ID("id"),
    DANGER_LEVEL("danger_level"),

    NONE("");



    String value;

    Tag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Tag getTagByValue(String value) {
        Tag[] values = Tag.values();
        for (Tag tag : values) {
            if(tag.value.equals(value)){
                return tag;
            }
        }
        throw new IllegalArgumentException();
    }
}
