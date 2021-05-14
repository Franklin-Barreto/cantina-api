package br.com.f2e.cantina.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.f2e.cantina.product.model.Product;
import br.com.f2e.cantina.product.model.dto.ProductInputDto;
import br.com.f2e.cantina.product.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	private final CategoryService categoryService;

	public ProductService(ProductRepository productRepository, CategoryService categoryService) {
		this.productRepository = productRepository;
		this.categoryService = categoryService;
	}

	public List<Product> findByIds(Iterable<Long> productsIds) {
		return this.productRepository.findAllById(productsIds);
	}

	public Product save(ProductInputDto productInputDto) {
		Product product = productInputDto.convert(categoryService);
		return productRepository.save(product);
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}
}
