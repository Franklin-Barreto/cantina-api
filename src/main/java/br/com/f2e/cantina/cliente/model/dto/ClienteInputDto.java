package br.com.f2e.cantina.cliente.model.dto;

import br.com.f2e.cantina.cliente.model.Customer;
import br.com.f2e.cantina.cliente.model.Address;

public class ClienteInputDto {

	private String nome;
	private String cpf;
	private EnderecoInputDto endereco;
	private String telefone;

	public ClienteInputDto(String nome, String cpf, EnderecoInputDto endereco, String telefone) {
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

	public EnderecoInputDto getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public Customer fromClienteDto() {
		return new Customer(nome, cpf, new Address(endereco.getLogradouro(), endereco.getNumero(), endereco.getCidade(),
				endereco.getEstado()), telefone);
	}

}
