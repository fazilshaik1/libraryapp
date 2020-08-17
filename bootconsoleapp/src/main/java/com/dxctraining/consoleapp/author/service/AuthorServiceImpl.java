package com.dxctraining.consoleapp.author.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.consoleapp.author.dao.IAuthorDao;
import com.dxctraining.consoleapp.author.entities.Author;
import com.dxctraining.consoleapp.author.exceptions.AuthorNullException;
import com.dxctraining.consoleapp.author.exceptions.InvalidAuthorArgumentException;

@Transactional
@Service
public class AuthorServiceImpl implements IAuthorService {
	
	@Autowired
	private IAuthorDao dao;

	@Override
	public void addAuthor(Author author) {
		validateAuthor(author);
		dao.addAuthor(author);
		
	}

	private void validateAuthor(Author author) {
		if(author == null) {
			throw new AuthorNullException("author is null");
		}
		
	}

	@Override
	public void removeAuthor(Author author) {
		validateAuthor(author);
		dao.removeAuthor(author);
		
	}

	@Override
	public Author updateAuthor(Author author) {
		validateAuthor(author);
		dao.updateAuthor(author);
		return author;
	}

	@Override
	public Author findAuthorId(int id) {
		validateId(id);
		Author author = dao.findAuthorId(id);
		return author;
	}

	private void validateId(int id) {
		if(id == 0) {
			throw new InvalidAuthorArgumentException("id is null");
		}
		
	}

	@Override
	public Author saveAuthor(Author author) {
		validateAuthor(author);
		dao.saveAuthor(author);
		return author;
	}

}
