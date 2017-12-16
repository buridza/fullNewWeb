package by.htp.library.service.impl;

import by.htp.library.dao.BookDAO;
import by.htp.library.dao.DAOFactory;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.Book;
import by.htp.library.service.BookService;
import by.htp.library.service.exception.ServiceException;

public class BookServiceImpl implements BookService {

	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Book findBook(String title) throws ServiceException{
		// VALIDATION
		
		DAOFactory factory = DAOFactory.getInstance();
		BookDAO bookDAO = factory.getBookDAO();
		Book book;
		
		try {
			book = bookDAO.findBook(title);
		} catch (DAOException e) {
			throw new ServiceException("message", e);
		}

		return book;
	}

	@Override
	public boolean deleteBook(int idBook) {
		// TODO Auto-generated method stub
		return false;
	}

}
