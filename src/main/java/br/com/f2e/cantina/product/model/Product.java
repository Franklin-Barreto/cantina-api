package br.com.f2e.cantina.product.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private BigDecimal price;
	@ManyToOne
	@JoinColumn(name = "category_fk")
	private Category category;

	public Product(String name, double price, Category category) {
		super();
		this.name = name;
		this.price = new BigDecimal(price);
		this.category = category;
	}
	
	protected Product() {}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Category getCategory() {
		return category;
	}

}
