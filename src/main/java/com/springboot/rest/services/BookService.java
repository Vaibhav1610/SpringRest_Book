package com.springboot.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.rest.dao.BookRepository;
import com.springboot.rest.entity.Book;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

//	public static List<Book> bookList = new ArrayList<Book>();
//
//	static {
//		bookList.add(new Book(1, "Book1", "Vaibhav"));
//		bookList.add(new Book(12, "Book12", "mani"));
//		bookList.add(new Book(13, "Book13", "karna"));
//		bookList.add(new Book(15, "Book15", "sooraj"));
//		bookList.add(new Book(14, "Book14", "ravi"));
//	}

	public List<Book> getBooks() {

		List<Book> list = (List)bookRepository.findAll();
		return list;
		

	}

	public  Book getBookById(int id) {
		
		
		Book b = bookRepository.findById(id);
		return b;

//		Book book = null;
//
//		try {
//			for (Book b : bookList) {
//				if (id == b.getId()) {
//					int index = bookList.indexOf(b);
//					book = bookList.get(index);
//					return book;
//				}
//
//			}
//
//			
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return book;
	}

	public Book addbook(Book b) {
		 Book book = bookRepository.save(b);
		 return book;
	}

	public  void deleteBook(int id) {
		//bookList = bookList.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
		
		bookRepository.deleteById(id);
	}

	public  void updateBook(Book book, int id) {
		
		book.setId(id);
		bookRepository.save(book);
		
		
//		bookList = bookList.stream().map(b -> {
//			if (b.getId() == id) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());

	}

}
