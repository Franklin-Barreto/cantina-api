package br.com.f2e.cantina.order.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.f2e.cantina.customer.model.Customer;
import br.com.f2e.cantina.customer.service.CustomerService;
import br.com.f2e.cantina.order.model.Order;
import br.com.f2e.cantina.order.model.OrderItem;
import br.com.f2e.cantina.order.model.dto.OrderInputDto;
import br.com.f2e.cantina.order.model.dto.OrderItemInputDto;
import br.com.f2e.cantina.order.repository.OrderRepository;
import br.com.f2e.cantina.product.service.ProductService;

@Service
public class OrderService {

	private final OrderRepository orderRepository;
	private final ProductService productService;
	private final CustomerService customerService;

	public OrderService(OrderRepository orderRepository, ProductService productService,
			CustomerService customerService) {
		this.orderRepository = orderRepository;
		this.productService = productService;
		this.customerService = customerService;
	}

	public Order save(OrderInputDto orderInputDto) {
		Customer customer = customerService.findById(orderInputDto.getCustomerId());
		Map<Long, Integer> map = orderInputDto.getOrderItens().stream()
				.collect(Collectors.toMap(OrderItemInputDto::getProductId, OrderItemInputDto::getQuantity));

		List<OrderItem> orderItens = productService.findByIds(map.keySet()).stream()
				.map(p -> new OrderItem(p, map.get(p.getId()))).collect(Collectors.toList());

		Order order = new Order(customer);
		order.addAllItens(orderItens);

		return orderRepository.save(order);
	}

	public Page<Order> findAll(Pageable pagination) {
		return orderRepository.findAll(pagination);
	}
}
