package br.com.f2e.cantina.customer.model.dto;

import br.com.f2e.cantina.customer.model.Address;
import br.com.f2e.cantina.customer.model.Customer;

public class ClienteInputDto {

	private String nome;
	private String cpf;
	private AddressInputDto endereco;
	private String telefone;

	public ClienteInputDto(String nome, String cpf, AddressInputDto endereco, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public AddressInputDto getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public Customer fromClienteDto() {
		return new Customer(nome, cpf, new Address(endereco.getStreet(), endereco.getNumber(), endereco.getCity(),
				endereco.getState()), telefone);
	}

}
