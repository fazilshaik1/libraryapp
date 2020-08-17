package com.dxctraining.consoleapp.author.dao;

import com.dxctraining.consoleapp.author.entities.Author;

public interface IAuthorDao {
	
	void addAuthor(Author author);
	void removeAuthor(Author author);
	Author updateAuthor(Author author);
	Author findAuthorId(int id);
	Author saveAuthor(Author author);

}
