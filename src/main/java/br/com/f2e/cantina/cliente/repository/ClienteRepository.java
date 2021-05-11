package br.com.f2e.cantina.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.f2e.cantina.cliente.model.Customer;

public interface ClienteRepository extends JpaRepository<Customer, Long> {

}
