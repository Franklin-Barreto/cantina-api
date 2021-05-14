package br.com.f2e.cantina.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.f2e.cantina.product.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
