package br.com.f2e.cantina.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	public Category(String name) {
		this.name = name;
	}

	protected Category() {
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
