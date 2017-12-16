package by.htp.library.service;

import by.htp.library.entity.User;
import by.htp.library.service.exception.ServiceException;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface UserService {
	
	void register(User user) throws ServiceException;
	User logination(String login, String password) throws ServiceException;
	ArrayList<User> getAll(String login, String password)throws ServiceException;

}
