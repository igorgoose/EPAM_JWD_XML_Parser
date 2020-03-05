package by.schepov.xmlparser.page;

public enum JSPElementName {
    COMMAND("command"),
    FILE("file");

    private String value;

    JSPElementName(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
