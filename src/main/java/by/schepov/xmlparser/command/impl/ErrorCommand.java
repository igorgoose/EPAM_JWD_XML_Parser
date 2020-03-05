package by.schepov.xmlparser.command.impl;

import by.schepov.xmlparser.command.Command;
import by.schepov.xmlparser.page.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return Page.ERROR.getValue();
    }
}
