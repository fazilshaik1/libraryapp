package com.dxctraining.consoleapp.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.consoleapp.book.dao.IBookDao;
import com.dxctraining.consoleapp.book.entities.Book;
import com.dxctraining.consoleapp.book.exceptions.BookNullException;

@Transactional
@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	private IBookDao dao;

	@Override
	public Book findBookId(int id) {
		validateId(id);
		Book book = dao.findBookId(id);
		return book;
	}

	private void validateId(int id) {
		if(id == 0) {
			throw new BookNullException("id is null");
		}
		
	}

	@Override
	public void addBook(Book book) {
		validateBook(book);
		dao.addBook(book);
		
	}

	private void validateBook(Book book) {
		if(book == null) {
			throw new BookNullException("book is null");
		}
		
	}

	@Override
	public void removeBook(Book book) {
		validateBook(book);
		dao.removeBook(book);
		
	}

	@Override
	public Book updateBook(Book book) {
		validateBook(book);
		dao.updateBook(book);
		return book;
	}

	@Override
	public Book updateBookcost(int id, double cost) {
		validateId(id);
		dao.updateBookcost(id, cost);
		return null;
	}

	@Override
	public Book saveBook(Book book) {
		validateBook(book);
		dao.saveBook(book);
		return book;
	}

	@Override
	public List<Book> showAll() {
		List<Book> list = dao.showAll();
		return list;
	}
	

}
