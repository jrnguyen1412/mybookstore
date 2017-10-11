package com.hungnd16.training.mybookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hungnd16.training.mybookstore.entity.Book;
import com.hungnd16.training.mybookstore.service.BookService;

@Controller
public class IndexController {

	@Autowired
	BookService bookService;

	@RequestMapping(value={"/"})
	public String index(Model model) {
		model.addAttribute("books", bookService.findAll());
		return "index";
	}

	//@RequestMapping(value="/book/addBook", method = RequestMethod.GET)
	@GetMapping(value="/book/addBook")
	public String showAddBook(Model model) {
		model.addAttribute("book", new Book());
		return "bookForm";
	}

	//@RequestMapping(value="/book/save", method = RequestMethod.POST)
	@PostMapping(value="/book/save")
	public String editBook(@ModelAttribute("book") Book book ) {
		bookService.save(book);
		return "redirect:/";
	}

	//@RequestMapping(value="/book/editBook", method = RequestMethod.GET)
	@GetMapping(value="/book/{bookId}/editBook")
	public String showEditBook(@PathVariable int bookId, Model model) {
		model.addAttribute("book", bookService.findOne(bookId));
		return "bookForm";
	}

	@GetMapping(value="/book/{bookId}/deleteBook")
	public String deleteBook(@PathVariable int bookId) {
		bookService.delete(bookId);
		return "redirect:/";
	}
}
