package com.alison.apiprodutos;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alison.apiprodutos.model.Category;
import com.alison.apiprodutos.model.Product;
import com.alison.apiprodutos.services.ProductsService;

import junit.framework.TestCase;

@SpringBootTest
class ApiprodutosApplicationTests extends TestCase {

	@Autowired
	private ProductsService productsService;

	@Test
	public void testSave() {
		Product p = new Product();
		p.setName("Teste");
		p.setAmount(2);
		p.setPrice(BigDecimal.valueOf(500));
		Category mockCategory = Mockito.mock(Category.class);
		p.setCategory(mockCategory);

		assertEquals("Teste", p.getName());
		assertEquals(2, p.getAmount());
		assertEquals(BigDecimal.valueOf(500), p.getPrice());
		assertEquals(mockCategory, p.getCategory());
	}

	@Test
	public void testFindAll() {
		List<Product> p = productsService.list();
		System.out.println(p);
	}

	@Test
	public void testDeletar() {
		Product mock = Mockito.mock(Product.class);
		productsService.delete(mock.getId());
	}

}
