package com.alison.apiprodutos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.alison.apiprodutos.model.Category;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
