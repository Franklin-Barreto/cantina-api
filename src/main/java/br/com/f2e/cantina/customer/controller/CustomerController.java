package br.com.f2e.cantina.customer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.f2e.cantina.customer.model.Customer;
import br.com.f2e.cantina.customer.model.dto.CustomerInputDto;
import br.com.f2e.cantina.customer.model.dto.CustomerUpdateDto;
import br.com.f2e.cantina.customer.model.dto.CustomerViewDto;
import br.com.f2e.cantina.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping
	public ResponseEntity<Customer> salvar(@RequestBody CustomerInputDto customerInput) {
		Customer cliente = this.customerService.adicionar(customerInput);
		return ResponseEntity.ok(cliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomerViewDto> update(@PathVariable Long id,
			@RequestBody CustomerUpdateDto customerUpdate) {
		Customer customer = customerService.update(id, customerUpdate);
		return ResponseEntity.ok(CustomerViewDto.convert(customer));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> obterCliente(@PathVariable Long id) {
		Customer cliente = this.customerService.findById(id);
		return ResponseEntity.ok(cliente);
	}

	@GetMapping
	public ResponseEntity<List<Customer>> obterClientes() {
		return ResponseEntity.ok(customerService.findAll());
	}

}
