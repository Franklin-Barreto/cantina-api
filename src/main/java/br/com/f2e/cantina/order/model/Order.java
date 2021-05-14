package br.com.f2e.cantina.order.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.f2e.cantina.customer.model.Customer;

@Entity
@Table(name = "\"ORDER\"")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate createdAt;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderItem> itens;
	@ManyToOne
	@JoinColumn(name = "customer_fk")
	private Customer customer;

	Order() {
	}

	public Order(Customer customer) {
		this.createdAt = LocalDate.now();
		this.customer = customer;
		this.itens = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public List<OrderItem> getItens() {
		return Collections.unmodifiableList(itens);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void addItem(OrderItem orderItem) {
		itens.add(orderItem);
		orderItem.setOrder(this);
	}

	public void addAllItens(List<OrderItem> orderItens) {
		orderItens.stream().forEach(orderItem -> {
			addItem(orderItem);
		});
	}

	public BigDecimal getTotalPrice() {
		return itens.stream().map(OrderItem::getTotalPrice).reduce(BigDecimal.ZERO, (BigDecimal::add));
	}
}
