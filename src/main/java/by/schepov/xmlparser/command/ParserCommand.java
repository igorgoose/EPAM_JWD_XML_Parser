package by.schepov.xmlparser.command;

import by.schepov.xmlparser.service.HttpParserService;

public abstract class ParserCommand implements Command {
    protected static final HttpParserService PARSER_SERVICE = HttpParserService.INSTANCE;


}
