package br.com.f2e.cantina.customer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.f2e.cantina.customer.model.Customer;
import br.com.f2e.cantina.customer.model.dto.ClienteInputDto;
import br.com.f2e.cantina.customer.service.CustomerService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	private final CustomerService clienteService;

	public ClienteController(CustomerService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	public ResponseEntity<Customer> salvar(@RequestBody ClienteInputDto clienteInput) {
		Customer cliente = this.clienteService.adicionar(clienteInput);
		return ResponseEntity.ok(cliente);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> obterCliente(@PathVariable Long id) {
		Customer cliente = this.clienteService.findById(id);
		return ResponseEntity.ok(cliente );
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> obterClientes(){
		return ResponseEntity.ok(clienteService.findAll());
	}

}
