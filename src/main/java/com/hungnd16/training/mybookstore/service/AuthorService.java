package com.hungnd16.training.mybookstore.service;

import java.util.List;

import com.hungnd16.training.mybookstore.entity.Author;

public interface AuthorService {
	Iterable<Author> findAll();
	
	List<Author> search(String query);
	
	Author findOne(int id);
	
	void save(Author author);
	
	void delete(int id);
}
