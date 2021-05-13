package br.com.f2e.cantina.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.f2e.cantina.customer.model.Address;
import br.com.f2e.cantina.customer.model.Customer;
import br.com.f2e.cantina.order.model.Order;
import br.com.f2e.cantina.order.model.OrderItem;
import br.com.f2e.cantina.order.repository.OrderRepository;
import br.com.f2e.cantina.product.model.Category;
import br.com.f2e.cantina.product.model.Product;

@DataJpaTest
class OrderRepositoryTest {

	@Autowired
	private OrderRepository orderRepository;
	private Address address;
	private Order order;

	@BeforeEach
	void initialize() {
		Product cocaCola = new Product("coca-cola", 5.0, new Category("drink"));
		Product sandwich = new Product("x-tudo", 15.0, new Category("food"));
		address = new Address("Av Osvaldo do Vale Cordeiro", "1360", "São Paulo", "SP");
		order = new Order(new Customer("Franklin", "12345679", address, "11975215595"));
		order.addItem(new OrderItem(cocaCola, 2));
		order.addItem(new OrderItem(sandwich, 2));
	}

	@Test
	void insertOrderTest() {
		Order orderSaved = orderRepository.save(order);
		assertNotNull(orderSaved);
		assertEquals(new BigDecimal(40), orderSaved.getTotalPrice());
	}

}
