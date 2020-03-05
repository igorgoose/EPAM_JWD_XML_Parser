package by.schepov.xmlparser.controller;

import by.schepov.xmlparser.command.Command;
import by.schepov.xmlparser.page.JSPElementName;
import by.schepov.xmlparser.factory.command.CommandFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(ControllerServlet.class);
    private static final CommandFactory COMMAND_FACTORY = CommandFactory.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("doGet");
        req.getRequestDispatcher("/jsp/result.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command command = COMMAND_FACTORY.getCommand(req.getParameter(JSPElementName.COMMAND.getValue()));
        String nextPagePath = command.execute(req, resp);
        req.getRequestDispatcher(nextPagePath).forward(req, resp);
    }


}
