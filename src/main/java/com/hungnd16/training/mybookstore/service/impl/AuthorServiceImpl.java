package com.hungnd16.training.mybookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungnd16.training.mybookstore.entity.Author;
import com.hungnd16.training.mybookstore.repository.AuthorRepository;
import com.hungnd16.training.mybookstore.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository repository;
	
	@Override
	public Iterable<Author> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Author> search(String name) {
		return repository.findByAuthorNameContaining(name);
	}

	@Override
	public Author findOne(int id) {
		return repository.findOne(id);
	}

	@Override
	public void save(Author author) {
		repository.save(author);
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
	}

}
