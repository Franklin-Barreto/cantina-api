package br.com.f2e.cantina.order.model.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.f2e.cantina.order.model.Order;

public class OrderViewDto {

	private Long id;
	private String customerName;
	private List<OrderItemView> itens = new ArrayList<>();
	private LocalDate createdAt;

	public OrderViewDto(Long id, String customerName, List<OrderItemView> itens, LocalDate createdAt) {
		this.id = id;
		this.customerName = customerName;
		this.itens = itens;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public List<OrderItemView> getItens() {
		return itens;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public static OrderViewDto converter(Order order) {

		List<OrderItemView> itens = order.getItens().stream().map(i -> new OrderItemView(i.getProduct().getName(),
				i.getQuantity(), i.getProduct().getPrice(), i.getTotalPrice())).collect(Collectors.toList());
		return new OrderViewDto(order.getId(), order.getCustomer().getName(), itens, order.getCreatedAt());
	}

	public static Page<OrderViewDto> converter(Page<Order> orders) {
		return orders.map(o -> converter(o));
	}

}
