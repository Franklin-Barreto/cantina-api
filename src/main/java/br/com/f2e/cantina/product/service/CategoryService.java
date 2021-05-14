package br.com.f2e.cantina.product.service;

import org.springframework.stereotype.Service;

import br.com.f2e.cantina.product.model.Category;
import br.com.f2e.cantina.product.repository.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public Category findById(Integer id) {
		return categoryRepository.getOne(id);
	}

}
