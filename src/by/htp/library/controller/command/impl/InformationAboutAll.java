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
import java.util.ArrayList;

public class InformationAboutAll implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               //System.out.println(request.g);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String goToPage;

        ArrayList<User> users = null;

        try {
            users = userService.getAll(login,password);
            if(users!=null){
                request.setAttribute("myuser", users);
                goToPage = "WEB-INF/jsp/adminList.jsp";
            }else {
                goToPage = "error.jsp";
                request.setAttribute("errorMessage", "у вас нет прав" );
            }

        } catch (ServiceException e) {
            goToPage = "error.jsp";
            request.setAttribute("errorMessage", "smth wrong...");
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(goToPage);
        dispatcher.forward(request, response);
    }
}
