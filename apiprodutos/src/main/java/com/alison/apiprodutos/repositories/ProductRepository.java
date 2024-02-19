package com.alison.apiprodutos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.alison.apiprodutos.model.Product;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "select * from products where name ilike %?1% ", nativeQuery = true)
	List<Product> findProductByName(String name);

}
