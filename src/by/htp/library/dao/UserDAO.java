package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;

import java.util.ArrayList;

public interface UserDAO {

	boolean register(User user) throws DAOException;
	User logination(String login, String password) throws DAOException;
	ArrayList getAll(String login, String password) throws DAOException;
}
