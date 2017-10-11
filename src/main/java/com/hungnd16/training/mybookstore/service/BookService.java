package com.hungnd16.training.mybookstore.service;

import java.util.List;

import com.hungnd16.training.mybookstore.entity.Book;

public interface BookService {
	Iterable<Book> findAll();

	List<Book> search(String query);

	Book findOne(int id);

	void save(Book book);

	void delete(int id);
}
