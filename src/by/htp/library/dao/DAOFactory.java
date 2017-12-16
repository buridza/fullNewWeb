package by.htp.library.dao;

import by.htp.library.dao.impl.SQLBookDAO;
import by.htp.library.dao.impl.SQLUserDAO;

public class DAOFactory {

	private static final DAOFactory factory = new DAOFactory();
    static {try{Class.forName("com.mysql.jdbc.Driver");}
    catch(ClassNotFoundException e){
        System.out.println("alarm");
    }}
	private final BookDAO bookDAO = new SQLBookDAO();
	private final UserDAO userDAO = new SQLUserDAO();

	private DAOFactory() {

	}

	public static DAOFactory getInstance() {
		return factory;
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

}
