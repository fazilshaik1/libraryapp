package com.dxctraining.consoleapp.author.service;

import com.dxctraining.consoleapp.author.entities.Author;

public interface IAuthorService {
	void addAuthor(Author author);
	void removeAuthor(Author author);
	Author updateAuthor(Author author);
	Author findAuthorId(int id);
	Author saveAuthor(Author author);

}
