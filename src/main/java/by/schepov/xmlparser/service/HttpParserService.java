package by.schepov.xmlparser.service;

import by.schepov.xmlparser.entity.Flower;
import by.schepov.xmlparser.exception.ParserException;
import by.schepov.xmlparser.exception.ParserServiceException;
import by.schepov.xmlparser.page.JSPElementName;
import by.schepov.xmlparser.parser.FlowerParser;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public enum HttpParserService {
    INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(HttpParserService.class);

    public List<Flower> getParsedData(HttpServletRequest request, FlowerParser parser) throws ParserServiceException {
        try {
            Part filePart = request.getPart(JSPElementName.FILE.getValue());
            InputStream inputStream = filePart.getInputStream();
            return parser.parse(inputStream);
        } catch (ServletException | IOException | ParserException e) {
            throw new ParserServiceException(e);
        }
    }
}
