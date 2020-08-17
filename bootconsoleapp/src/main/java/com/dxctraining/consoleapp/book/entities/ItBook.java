package com.dxctraining.consoleapp.book.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.dxctraining.consoleapp.author.entities.Author;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class ItBook extends Book{
	private String language;
	private double version;

	public ItBook(String name,Book book, Author author, double cost, String language, double version) {
		super(name,book, author, cost);
		this.language = language;
		this.version = version;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}
	

}
