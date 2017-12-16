package by.htp.library.service.impl;

import by.htp.library.dao.DAOFactory;
import by.htp.library.dao.UserDAO;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;
import by.htp.library.service.UserService;
import by.htp.library.service.exception.ServiceException;

import java.util.ArrayList;

public class UserServiceImpl implements UserService {

    @Override
    public void register(User user) {
        // TODO Auto-generated method stub

    }

    @Override
    public User logination(String login, String password) throws ServiceException {
        // validation

        User user = null;

        DAOFactory factory = DAOFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();

        try {
            user = userDAO.logination(login, password);
        } catch (DAOException e) {
            throw new ServiceException("my message", e);
        }

        return user;
    }

    @Override
    public ArrayList<User> getAll(String login, String password) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        ArrayList<User> arrayList = null;
        try {
            arrayList = userDAO.getAll(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return arrayList;
    }
}
