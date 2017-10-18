package com.hungnd16.training.mybookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hungnd16.training.mybookstore.entity.Author;
import com.hungnd16.training.mybookstore.service.AuthorService;

@Controller
public class AuthorController {
	@Autowired
	AuthorService service;
	
	@GetMapping(value = "/author/")
	public String showAuthors(Model model) {
		model.addAttribute("authors", service.findAll());
		return "/author/authors";
	}
	
	@GetMapping(value = "/author/addAuthor")
	public String showAddAuthor(Model model) {
		model.addAttribute("author", new Author());
		return "/author/authorForm";
	}
	
	@PostMapping(value="/author/save")
	public String save(@ModelAttribute("author") Author author) {
		service.save(author);
		return "redirect:/author/";
	}
	
	@GetMapping(value="/author/{authorId}/edit")
	public String showEditAuthor(@PathVariable int authorId, Model model) {
		model.addAttribute("author", service.findOne(authorId));
		return "/author/authorForm";
	}
	
	@GetMapping(value="/author/{authorId}/delete")
	public String delete(@PathVariable int authorId) {
		service.delete(authorId);
		return "redirect:/author/";
	}
	
	@PostMapping(value="/author/search")
	public String searchAuthor(@RequestParam("query") String query, Model model) {
		if (StringUtils.isEmpty(query)) {
			return "redirect:/author/";
		}
		
		model.addAttribute("authors", service.search(query));
		return "/author/authors";
	}
}
