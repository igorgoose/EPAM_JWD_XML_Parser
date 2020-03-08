package by.schepov.xmlparser.service;

import by.schepov.xmlparser.entity.Flower;
import by.schepov.xmlparser.exception.ParserException;
import by.schepov.xmlparser.exception.ParserServiceException;
import by.schepov.xmlparser.exception.XMLValidatorException;
import by.schepov.xmlparser.page.JSPElementName;
import by.schepov.xmlparser.parser.FlowerParser;
import by.schepov.xmlparser.validator.XMLValidator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public enum HttpParserService {
    INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(HttpParserService.class);
    private static final XMLValidator VALIDATOR = new XMLValidator();
    private static final String SCHEMA_NAME = "flowers.xsd";

    public List<Flower> getParsedData(HttpServletRequest request, FlowerParser parser) throws ParserServiceException {
        try {
            Part filePart = request.getPart(JSPElementName.FILE.getValue());
            InputStream inputStreamValidate = filePart.getInputStream();
            VALIDATOR.validateXMLFile(inputStreamValidate, SCHEMA_NAME);
            InputStream inputStreamParse = filePart.getInputStream();
            return parser.parse(inputStreamParse);
        } catch (ServletException | IOException | ParserException | XMLValidatorException e) {
            LOGGER.warn(e);
            throw new ParserServiceException(e);
        }
    }
}
