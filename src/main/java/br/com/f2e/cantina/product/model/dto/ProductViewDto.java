package br.com.f2e.cantina.product.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.f2e.cantina.product.model.Product;

public class ProductViewDto {

	private Long id;
	private String name;
	private double price;
	private int categoryId;
	private String categoryName;

	public ProductViewDto(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice().doubleValue();
		this.categoryId = product.getCategory().getId();
		this.categoryName = product.getCategory().getName();
	}
	
	public Long getId() {
		return id;
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

	public String getCategoryName() {
		return categoryName;
	}

	public static ProductViewDto fromProduct(Product product) {
		return new ProductViewDto(product);
	}

	public static List<ProductViewDto> fromListProduct(List<Product> products) {
		return products.stream().map(ProductViewDto::new).collect(Collectors.toList());
	}

}
