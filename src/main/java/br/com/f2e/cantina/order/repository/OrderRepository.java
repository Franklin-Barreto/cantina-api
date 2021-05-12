package br.com.f2e.cantina.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.f2e.cantina.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
