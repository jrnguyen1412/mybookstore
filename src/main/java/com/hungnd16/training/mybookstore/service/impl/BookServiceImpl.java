package com.hungnd16.training.mybookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungnd16.training.mybookstore.entity.Book;
import com.hungnd16.training.mybookstore.repository.BookRepository;
import com.hungnd16.training.mybookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository repository;

	@Override
	public Iterable<Book> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Book> search(String query) {
		return repository.findByBookNameContaining(query);
		//return new ArrayList<Book>();
	}

	@Override
	public Book findOne(int id) {
		return repository.findOne(id);
	}

	@Override
	public void save(Book book) {
		repository.save(book);
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
	}

}
