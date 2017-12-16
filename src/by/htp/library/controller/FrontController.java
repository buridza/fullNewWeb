package by.htp.library.controller;

import by.htp.library.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final CommandProvider provider = new CommandProvider();
	
    public FrontController() {
        super();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		
		Command commandObject = provider.getCommand(command);
		
		commandObject.execute(request, response);
		
		doGet(request, response);
	}

}
