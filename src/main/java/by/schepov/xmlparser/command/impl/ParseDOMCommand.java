package by.schepov.xmlparser.command.impl;

import by.schepov.xmlparser.command.Command;
import by.schepov.xmlparser.page.JSPElementName;
import by.schepov.xmlparser.page.Page;
import by.schepov.xmlparser.page.RequestAttributeName;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ParseDOMCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Part filePart = request.getPart(JSPElementName.FILE.getValue());

            request.setAttribute(RequestAttributeName.RESULT.getValue(), "asd");
            return Page.RESULT.getValue();
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
        return Page.ERROR.getValue();
    }
}
