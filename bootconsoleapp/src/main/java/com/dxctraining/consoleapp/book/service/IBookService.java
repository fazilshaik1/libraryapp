package com.dxctraining.consoleapp.book.service;

import java.util.List;

import com.dxctraining.consoleapp.book.entities.Book;

public interface IBookService {
	Book findBookId(int id);
    void addBook(Book book);
    void removeBook(Book book);
    Book updateBook(Book book);
    Book updateBookcost(int id,double cost);
    Book saveBook(Book book);
    List showAll();

}
