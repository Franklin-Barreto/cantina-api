package br.com.f2e.cantina.customer.model;

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
	private String name;
	private String cpf;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER, optional = false)
	private Address address;
	private String phone;

	public Customer() {
	}

	public Customer(String nome, String cpf, Address address, String phone) {
		this.name = nome;
		this.cpf = cpf;
		this.address = address;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public Address getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void updateAddress(Address address) {
		this.address.update(address);
	}
}
