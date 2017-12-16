package by.htp.library.service;

import by.htp.library.entity.Book;
import by.htp.library.service.exception.ServiceException;

public interface BookService {
	boolean addBook(Book book) throws ServiceException;
	Book findBook(String title) throws ServiceException;
	boolean deleteBook(int idBook) throws ServiceException;
}
