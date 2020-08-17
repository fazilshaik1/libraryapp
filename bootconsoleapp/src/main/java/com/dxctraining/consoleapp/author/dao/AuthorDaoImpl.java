package com.dxctraining.consoleapp.author.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dxctraining.consoleapp.author.entities.Author;
import com.dxctraining.consoleapp.author.exceptions.AuthorNullException;

@Repository
public class AuthorDaoImpl implements IAuthorDao {
	
	@Autowired
	private EntityManager em;

	@Override
	public void addAuthor(Author author) {
		em.persist(author);
		
	}

	@Override
	public void removeAuthor(Author author) {
		em.remove(author);
		
	}

	@Override
	public Author updateAuthor(Author author) {
		em.merge(author);
		return author;
	}

	@Override
	public Author findAuthorId(int id) {
		Author author = em.find(Author.class, id);
		if(author == null) {
			throw new AuthorNullException("author is null");
		}
		return author;
	}

	@Override
	public Author saveAuthor(Author author) {
		em.persist(author);
		return author;
	}

}
