package by.schepov.xmlparser.parser;

public enum XMLNamesRegex {
    IGNORED_TAG("#text"),
    ID_ATTRIBUTE("ID");

    private String regex;

    XMLNamesRegex(String regex){
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

}
