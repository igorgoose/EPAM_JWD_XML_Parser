package by.schepov.xmlparser.page;

public enum Page {
    RESULT("/jsp/result.jsp"), ERROR("/jsp/error.jsp"), HOME("index.jsp");

    private String value;

    Page(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
