package br.com.f2e.cantina.cliente.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.f2e.cantina.cliente.model.Customer;
import br.com.f2e.cantina.cliente.model.dto.ClienteInputDto;
import br.com.f2e.cantina.cliente.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
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
