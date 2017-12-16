package by.htp.library.controller.command.impl;

import by.htp.library.controller.command.Command;
import by.htp.library.entity.User;
import by.htp.library.service.ServiceFactory;
import by.htp.library.service.UserService;
import by.htp.library.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class LoginationCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		
		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		
		User user = null;
		String goToPage;
		try {
			user = userService.logination(login, password);
			
			if(user != null) {
				request.setAttribute("myuser", user);
				goToPage= "/WEB-INF/jsp/main.jsp";
			}else {
				goToPage= "error.jsp";
				request.setAttribute("errorMessage", "no such user");
			}
		} catch (ServiceException e) {
			// logging
			e.printStackTrace();//stub
			request.setAttribute("errorMessage", "smth wrong...");
			goToPage = "error.jsp";
		}



		
		RequestDispatcher dispatcher = request.getRequestDispatcher(goToPage);

        dispatcher.forward(request, response);
		
	}

	

}
