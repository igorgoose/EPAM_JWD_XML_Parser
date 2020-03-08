package by.schepov.xmlparser.page;

public enum RequestAttributeName {
    RESULT("result"),
    ERROR_MESSAGE("errorMessage");

    private String value;

    RequestAttributeName(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
