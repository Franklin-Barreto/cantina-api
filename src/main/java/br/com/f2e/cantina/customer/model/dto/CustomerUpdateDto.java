package br.com.f2e.cantina.customer.model.dto;

import br.com.f2e.cantina.customer.model.Address;

public class CustomerUpdateDto {

	private Address address;
	private String phone;

	public CustomerUpdateDto(String phone,Address address) {
		this.phone = phone;
		this.address = address;
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
}
