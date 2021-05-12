package br.com.f2e.cantina.order.model.dto;

public class OrderItemInputDto {

	private long productId;
	private int quantity;

	public OrderItemInputDto(long productId, int quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

	public long getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}

}
