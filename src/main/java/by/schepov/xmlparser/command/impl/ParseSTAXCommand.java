package by.schepov.xmlparser.command.impl;

import by.schepov.xmlparser.command.ParserCommand;
import by.schepov.xmlparser.exception.ParserServiceException;
import by.schepov.xmlparser.page.Page;
import by.schepov.xmlparser.page.RequestAttributeName;
import by.schepov.xmlparser.parser.impl.stax.StAXFlowerParser;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParseSTAXCommand extends ParserCommand {

    private static final Logger LOGGER = Logger.getLogger(ParseSTAXCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute(RequestAttributeName.RESULT.getValue(),
                    PARSER_SERVICE.getParsedData(request, new StAXFlowerParser()));
            return Page.RESULT.getValue();
        } catch (ParserServiceException e) {
            LOGGER.error(e);
        }
        return Page.ERROR.getValue();
    }
}
