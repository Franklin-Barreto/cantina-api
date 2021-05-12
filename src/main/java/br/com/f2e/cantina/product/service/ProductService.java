package br.com.f2e.cantina.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.f2e.cantina.product.model.Product;
import br.com.f2e.cantina.product.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> findByIds(Iterable<Long> productsIds) {
		return this.productRepository.findAllById(productsIds);
	}
}
