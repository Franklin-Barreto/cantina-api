package br.com.f2e.cantina.customer.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import br.com.f2e.cantina.customer.model.Customer;
import br.com.f2e.cantina.customer.model.dto.CustomerInputDto;
import br.com.f2e.cantina.customer.model.dto.CustomerUpdateDto;
import br.com.f2e.cantina.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer adicionar(CustomerInputDto customerDto) {
		return this.customerRepository.save(customerDto.fromClienteDto());
	}

	public Customer findById(Long id) {
		return customerRepository.findById(id).orElseThrow(() -> new NoSuchElementException ("Not found"));
	}

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public Customer update(Long id, CustomerUpdateDto customerUpdate) {
		Customer customer = customerRepository.getOne(id);
		customer.setPhone(customerUpdate.getPhone());
		customer.updateAddress(customerUpdate.getAddress());
		return customer;
	}

}
