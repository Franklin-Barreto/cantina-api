package br.com.f2e.cantina.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.f2e.cantina.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT p FROM Product p join fetch p.category where p.id IN :ids")
	List<Product> findAllById(Iterable<Long> ids);
}
