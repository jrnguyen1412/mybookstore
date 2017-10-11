package com.hungnd16.training.mybookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hungnd16.training.mybookstore.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	List<Book> findByBookId(String query);
}
