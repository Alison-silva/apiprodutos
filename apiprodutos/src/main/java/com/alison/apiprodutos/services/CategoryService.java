package com.alison.apiprodutos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alison.apiprodutos.model.Category;
import com.alison.apiprodutos.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> list() {
		return categoryRepository.findAll();
	}

}
