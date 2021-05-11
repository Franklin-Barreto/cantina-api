package br.com.f2e.cantina.cliente.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER, optional = false)
	private Address endereco;
	private String telefone;

	public Customer() {
	}

	public Customer(String nome, String cpf, Address endereco, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public Address getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void atuaLizaEndereco(Address endereco) {
		this.endereco = endereco;
	}

}
