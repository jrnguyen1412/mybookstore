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

import com.hungnd16.training.mybookstore.entity.Book;
import com.hungnd16.training.mybookstore.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping(value="/book/")
	public String showBooks(Model model) {
		model.addAttribute("books",bookService.findAll());
		return "/book/books";
	}

	//@RequestMapping(value="/book/addBook", method = RequestMethod.GET)
	@GetMapping(value="/book/addBook")
	public String showAddBook(Model model) {
		model.addAttribute("book", new Book());
		return "/book/bookForm";
	}

	//@RequestMapping(value="/book/save", method = RequestMethod.POST)
	@PostMapping(value="/book/save")
	public String save(@ModelAttribute("book") Book book ) {
		bookService.save(book);
		return "redirect:/book/";
	}

	//@RequestMapping(value="/book/editBook", method = RequestMethod.GET)
	@GetMapping(value="/book/{bookId}/edit")
	public String showEditBook(@PathVariable int bookId, Model model) {
		model.addAttribute("book", bookService.findOne(bookId));
		return "/book/bookForm";
	}

	@GetMapping(value="/book/{bookId}/delete")
	public String delete(@PathVariable int bookId) {
		bookService.delete(bookId);
		return "redirect:/book/";
	}
	
	@PostMapping(value="/book/search")
	public String searchBook(@RequestParam("query") String query, Model model) {
		if (StringUtils.isEmpty(query)) {
			return "redirect:/book/";
		}
		
		model.addAttribute("books", bookService.search(query));
		return "/book/books";
	}
}
