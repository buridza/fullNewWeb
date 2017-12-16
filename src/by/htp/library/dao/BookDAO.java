package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.Book;

public interface BookDAO {
	
	boolean addBook(Book book) throws DAOException;
	
	Book findBook(String title) throws DAOException;
	
	boolean deleteBook(int idBook) throws DAOException;

}
