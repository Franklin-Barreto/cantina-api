package br.com.f2e.cantina.product.model.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

import br.com.f2e.cantina.product.model.Category;
import br.com.f2e.cantina.product.model.Product;
import br.com.f2e.cantina.product.service.CategoryService;

public class ProductInputDto {

	@NotEmpty
	private String name;
	@DecimalMin(value = "0.01")
	private double price;
	private int categoryId;

	public ProductInputDto(String name, double price, int categoryId) {
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public Product convert(CategoryService categoryService) {

		Category category = categoryService.findById(categoryId);
		return new Product(name, price, category);
	}

}
