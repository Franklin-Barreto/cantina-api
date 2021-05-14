package br.com.f2e.cantina.order.model.dto;

import java.math.BigDecimal;

public class OrderItemView {

	private String productName;
	private int quantity;
	private BigDecimal price;
	private BigDecimal totalPrice;

	public OrderItemView(String productName, int quantity, BigDecimal price, BigDecimal totalPrice) {
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
	}

	public String getProductName() {
		return productName;
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

}
