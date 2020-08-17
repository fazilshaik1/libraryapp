package com.dxctraining.consoleapp.book.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.dxctraining.consoleapp.author.entities.Author;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class FictionBook extends Book {
	private String characterName;
	
	public FictionBook(String name, Book book, Author author, double cost, String characterName) {
		super(name, book, author, cost);
		this.characterName = characterName;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	
}
