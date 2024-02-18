package com.alison.apiprodutos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alison.apiprodutos.model.Category;
import com.alison.apiprodutos.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public ResponseEntity<Category> saveCateg(@RequestBody Category category) {
		Category c = categoryService.save(category);
		return new ResponseEntity<Category>(c, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Category>> list() {
		List<Category> listCateg = categoryService.list();
		return new ResponseEntity<List<Category>>(listCateg, HttpStatus.OK);
	}

}
