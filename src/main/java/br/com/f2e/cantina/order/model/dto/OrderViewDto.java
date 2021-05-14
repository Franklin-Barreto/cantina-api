package br.com.f2e.cantina.order.model.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderViewDto {

	private Long id;
	private String customerName;
	private List<OrderItemView> itens = new ArrayList<>();
}
