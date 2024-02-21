package com.alison.apiprodutos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alison.apiprodutos.model.Product;
import com.alison.apiprodutos.services.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductsService productsService;

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product newProduct = productsService.save(product);
		return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Product>> list() {
		List<Product> product = productsService.list();
		return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Product> update(@RequestBody Product product) {
		Product p = productsService.update(product);
		return new ResponseEntity<Product>(p, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable("id") Long id) {
		productsService.delete(id);
		return "Deletado com sucesso!";
	}

	@GetMapping(value = "/findIdProd/{id}")
	public ResponseEntity<Product> findByIdProd(@PathVariable(value = "id") Long id) {
		Optional<Product> prod = productsService.findByIdProduct(id);
		return new ResponseEntity<Product>(prod.get(), HttpStatus.OK);
	}

	@GetMapping(value = "/productforname/{name}")
	public ResponseEntity<List<Product>> productForName(@PathVariable("name") String name) {

		List<Product> list = productsService.findProductByName(name);

		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}

	@GetMapping(value = "/productforcategory/{category}")
	public ResponseEntity<List<Product>> productForCategory(@PathVariable("category") String category) {

		List<Product> list = productsService.findProductByCategory(category);

		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}

}
