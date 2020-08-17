package com.dxctraining.consoleapp.ui;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctraining.consoleapp.author.entities.Author;
import com.dxctraining.consoleapp.author.service.IAuthorService;
import com.dxctraining.consoleapp.book.entities.Book;
import com.dxctraining.consoleapp.book.entities.FictionBook;
import com.dxctraining.consoleapp.book.entities.ItBook;
import com.dxctraining.consoleapp.book.service.IBookService;

@Component
public class LibraryUi {
	@Autowired
	private IAuthorService authorService;
	@Autowired
	private IBookService bookService;
	
	@PostConstruct
	public void runUi() {
		try {
			Author author1 = new Author("Herbert");
			Author author2 = new Author("Shakespeare");
			Author author3 = new Author("Conan Doyle");
			Author author4 = new Author("Balaguruswamy");
			author1 = authorService.saveAuthor(author1);
			author2 = authorService.saveAuthor(author2);
			author3 = authorService.saveAuthor(author3);
			author4 = authorService.saveAuthor(author4);
			Book b1 = new Book(001);
			Book b2 = new Book(002);
			Book b3 = new Book(003);
			Book b4 = new Book(004);
			ItBook book1 = new ItBook("Core Java", b1, author1, 500, "English", 2.0);
			bookService.saveBook(book1);
			FictionBook book2 = new FictionBook("Macbeth", b2, author2, 600, "Lady Macbeth");
			bookService.saveBook(book2);
			FictionBook book3 = new FictionBook("Sherlock Holmes", b3, author3, 700, "Sherlock");
			bookService.saveBook(book3);
			ItBook book4 = new ItBook("Programming in Ansi C", b4, author4, 800, "English", 3.0);
			bookService.saveBook(book4);
			
			int id1 = author1.getId();
			Author fetched = authorService.findAuthorId(id1);
			System.out.println("fetched Author "+fetched.getName());
			
			displayAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void displayAll() {
		List<Book> list = bookService.showAll();
		for(Book book:list) {
			displayBook(book);
		}
	}
	public void displayBook(Book book) {
		System.out.println(" BookId is "+book.getId()+"Book name is "+book.getName()+"Book cost is "+book
				.getCost());
		Author author = book.getAuthor();
		System.out.println("Author id is "+author.getId()+" Author name is "+author.getName());
		if(book instanceof ItBook) {
			ItBook ib = (ItBook) book;
			System.out.println("language is "+ib.getLanguage()+" version is "+ib.getVersion());
		}
		if(book instanceof FictionBook) {
			FictionBook fb =(FictionBook)book;
			System.out.println("Character name is "+fb.getCharacterName());
		}
		
	}

}
