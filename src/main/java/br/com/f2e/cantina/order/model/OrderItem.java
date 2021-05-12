package br.com.f2e.cantina.order.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.f2e.cantina.product.model.Product;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "product_fk")
	private Product product;
	private int quantity;
	private BigDecimal price;
	private BigDecimal totalPrice;
	@ManyToOne
	@JoinColumn(name = "order_fk")
	@JsonIgnore
	private Order order;

	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		this.price = product.getPrice();
		this.totalPrice = product.getPrice().multiply(new BigDecimal(quantity));
	}

	protected OrderItem() {
	}

	public Long getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public Order getOrder() {
		return order;
	}

	protected void setOrder(Order order) {
		this.order = order;
	}

}
