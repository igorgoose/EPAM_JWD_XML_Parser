package by.schepov.xmlparser.controller;

import by.schepov.xmlparser.command.Command;
import by.schepov.xmlparser.page.JSPElementName;
import by.schepov.xmlparser.factory.command.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
@MultipartConfig(maxFileSize = 10240)
public class ControllerServlet extends HttpServlet {

    private static final CommandFactory COMMAND_FACTORY = CommandFactory.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command command = COMMAND_FACTORY.getCommand(req.getParameter(JSPElementName.COMMAND.getValue()));
        String nextPagePath = command.execute(req, resp);
        req.getRequestDispatcher(nextPagePath).forward(req, resp);
    }
}

