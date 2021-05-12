package br.com.f2e.cantina.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.f2e.cantina.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
