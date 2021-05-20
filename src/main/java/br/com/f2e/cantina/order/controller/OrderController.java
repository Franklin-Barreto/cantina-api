package br.com.f2e.cantina.order.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.f2e.cantina.order.model.Order;
import br.com.f2e.cantina.order.model.dto.OrderInputDto;
import br.com.f2e.cantina.order.model.dto.OrderViewDto;
import br.com.f2e.cantina.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	public ResponseEntity<Order> saveOrder(@RequestBody OrderInputDto orderInputDto) {
		return ResponseEntity.ok(this.orderService.save(orderInputDto));
	}

	@GetMapping
	public ResponseEntity<Page<OrderViewDto>> findAll(int pagina, int quantidade) {
		Pageable pagination = PageRequest.of(pagina, quantidade);
		return ResponseEntity.ok(OrderViewDto.converter(orderService.findAll(pagination)));
	}

}
