package by.schepov.xmlparser.entity;

public enum Colour {
    BLACK("black"),
    WHITE("white"),
    RED("red"),
    GREEN("green"),
    YELLOW("yellow"),
    BROWN("brown"),
    PURPLE("purple"),
    VIOLET("violet"),
    ORANGE("orange"),
    BURGUNDY("burgundy"),
    VARIOUS("various");

    private String value;

    Colour(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Colour getColourByValue(String value){
        Colour[] values = Colour.values();
        for (Colour colour: values) {
            if(colour.value.equals(value)){
                return colour;
            }
        }
        throw new IllegalArgumentException();
    }


}
