package by.schepov.xmlparser.command.impl;

import by.schepov.xmlparser.command.Command;
import by.schepov.xmlparser.page.Page;
import by.schepov.xmlparser.page.RequestAttributeName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParseSAXCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute(RequestAttributeName.RESULT.getValue(), "sax");
        return Page.RESULT.getValue();
    }
}