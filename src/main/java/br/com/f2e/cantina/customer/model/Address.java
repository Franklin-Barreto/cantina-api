package br.com.f2e.cantina.customer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String street;
	private String number;
	private String city;
	private String state;

	public Address(String street, String number, String city, String state) {
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
	}

	protected Address() {
	}

	public Long getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public String getNumber() {
		return number;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

}
