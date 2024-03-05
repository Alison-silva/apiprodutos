package com.alison.apiprodutos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.alison.apiprodutos.repositories" })
public class ApiprodutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiprodutosApplication.class, args);
		
	}

}
