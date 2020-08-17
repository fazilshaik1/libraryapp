package com.dxctraining.consoleapp.book.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.dxctraining.consoleapp.author.entities.Author;

@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private int id;
    private String name;
    private double cost;
    private Book book;
    private int booknum;
    
    @ManyToOne
    private Author author;

    public Book(String name,Book book, Author author, double cost){
        this.name = name;
        this.book = book;
        this.author = author;
        this.cost = cost;
    }
    public Book(int booknum) {
    	this.booknum = booknum;
    }

    public int getBooknum() {
		return booknum;
	}
	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}
	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    public int hashCode() {
    	return id;
    }
    public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if ((null == o) || !(o instanceof Book)) {
			return false;
		}
		Book that = (Book) o;
		boolean isequals = this.id == that.id;
		return isequals;
	}

}
