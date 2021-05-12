package br.com.f2e.cantina.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.f2e.cantina.customer.model.Customer;
import br.com.f2e.cantina.customer.model.dto.ClienteInputDto;
import br.com.f2e.cantina.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	private final CustomerRepository clienteRepository;

	public CustomerService(CustomerRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Customer adicionar(ClienteInputDto clienteDto) {
		return this.clienteRepository.save(clienteDto.fromClienteDto());
	}

	public Customer findById(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe"));
	}

	public List<Customer> findAll() {
		return clienteRepository.findAll();
	}

}
