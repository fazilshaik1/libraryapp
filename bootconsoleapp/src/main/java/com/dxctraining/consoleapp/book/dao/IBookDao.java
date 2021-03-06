package com.dxctraining.consoleapp.book.dao;

import java.util.List;

import com.dxctraining.consoleapp.book.entities.Book;

public interface IBookDao {
	Book findBookId(int id);
    void addBook(Book book);
    void removeBook(Book book);
    Book updateBook(Book book);
    Book updateBookcost(int id,double cost);
    Book saveBook(Book book);
    List showAll();

}
