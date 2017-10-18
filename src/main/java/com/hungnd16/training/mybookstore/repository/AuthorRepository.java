package com.hungnd16.training.mybookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hungnd16.training.mybookstore.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	public List<Author> findByAuthorNameContaining(String name);
}
