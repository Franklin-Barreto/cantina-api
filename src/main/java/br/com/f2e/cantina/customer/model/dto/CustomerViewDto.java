package br.com.f2e.cantina.customer.model.dto;

import br.com.f2e.cantina.customer.model.Address;
import br.com.f2e.cantina.customer.model.Customer;

public class CustomerViewDto {

	private String name;
	private String phone;
	private Address address;

	public CustomerViewDto(Customer customer) {
		this.name = customer.getName();
		this.address = customer.getAddress();
		this.phone = customer.getPhone();
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public Address getAddress() {
		return address;
	}

	public static CustomerViewDto convert(Customer customer) {

		return new CustomerViewDto(customer);
	}
}
