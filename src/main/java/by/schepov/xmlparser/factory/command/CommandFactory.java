package by.schepov.xmlparser.factory.command;

import by.schepov.xmlparser.command.Command;
import by.schepov.xmlparser.command.CommandType;
import by.schepov.xmlparser.command.impl.ErrorCommand;
import by.schepov.xmlparser.command.impl.ParseDOMCommand;
import by.schepov.xmlparser.command.impl.ParseSAXCommand;
import by.schepov.xmlparser.command.impl.ParseSTAXCommand;

import java.util.HashMap;

public enum CommandFactory {
    INSTANCE;

    private HashMap<CommandType, Command> commandRepository = new HashMap<>();
    private ErrorCommand errorCommand = new ErrorCommand();

    CommandFactory(){
        commandRepository.put(CommandType.PARSE_DOM, new ParseDOMCommand());
        commandRepository.put(CommandType.PARSE_SAX, new ParseSAXCommand());
        commandRepository.put(CommandType.PARSE_STAX, new ParseSTAXCommand());
    }

    public Command getCommand(String commandName){
        CommandType commandType = CommandType.valueOf(commandName);
        if(commandRepository.containsKey(commandType)){
            return commandRepository.get(commandType);
        }
        return errorCommand;
    }
}
