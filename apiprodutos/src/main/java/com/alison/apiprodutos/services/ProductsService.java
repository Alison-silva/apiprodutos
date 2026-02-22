package com.alison.apiprodutos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alison.apiprodutos.model.Product;
import com.alison.apiprodutos.repositories.ProductRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductRepository productRepository;

	public Product save(Product product) {
		if (productRepository.existsByName(product.getName())) {
			throw new IllegalArgumentException("Um produto com esse nome já foi cadastrado!");
		}
		return productRepository.save(product);
	}

	public List<Product> list() {
		return productRepository.findAll();
	}

	public Product update(Product product) {
		return productRepository.saveAndFlush(product);
	}

	public void delete(Long id) {
		productRepository.deleteById(id);
	}

	public Optional<Product> findByIdProduct(Long id) {
		return productRepository.findById(id);
	}

	public List<Product> findProductByName(String name) {
		return productRepository.findProductByName(name);
	}

	public List<Product> findProductByCategory(String category) {
		return productRepository.findProductByCategory(category);
	}

}
