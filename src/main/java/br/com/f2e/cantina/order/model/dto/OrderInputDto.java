package br.com.f2e.cantina.order.model.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderInputDto {

	private Long customerId;
	private List<OrderItemInputDto> orderItens = new ArrayList<>();

	public OrderInputDto(Long customerId, List<OrderItemInputDto> orderItens) {
		this.customerId = customerId;
		this.orderItens = orderItens;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public List<OrderItemInputDto> getOrderItens() {
		return orderItens;
	}

}
