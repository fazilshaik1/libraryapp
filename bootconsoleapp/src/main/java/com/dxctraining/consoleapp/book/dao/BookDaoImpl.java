package com.dxctraining.consoleapp.book.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dxctraining.consoleapp.book.entities.Book;
import com.dxctraining.consoleapp.book.exceptions.BookNullException;

@Repository
public class BookDaoImpl implements IBookDao{
	
	@Autowired
	private EntityManager em;

	@Override
	public Book findBookId(int id) {
		Book book = em.find(Book.class, id);
		if(book == null) {
			throw new BookNullException("Book is null");
		}
		return book;
	}

	@Override
	public void addBook(Book book) {
		book = em.merge(book);
		
	}

	@Override
	public void removeBook(Book book) {
		em.remove(book);	
	}

	@Override
	public Book updateBook(Book book) {
		book = em.merge(book);
		return book;
	}

	@Override
	public Book updateBookcost(int id, double cost) {
		Book book = em.find(Book.class, id);
		em.merge(cost);
		return book;
	}

	@Override
	public Book saveBook(Book book) {
		em.persist(book);
		return book;
	}

	@Override
	public List showAll() {
		String jpaQuery = "from Book";
        Query query = em.createQuery(jpaQuery);
        query.setParameter("books",query);
        List<Book> list = query.getResultList();
        Book book = null;
        if (!list.isEmpty()) {
            book = list.get(0);
        }
		return list;
	}

}
