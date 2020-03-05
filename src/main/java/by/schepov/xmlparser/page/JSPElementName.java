package by.schepov.xmlparser.page;

public enum JSPElementName {
    COMMAND("command");

    private String value;

    JSPElementName(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
