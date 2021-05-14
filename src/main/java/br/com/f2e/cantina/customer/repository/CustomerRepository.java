package br.com.f2e.cantina.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.f2e.cantina.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByName(String name);
}
