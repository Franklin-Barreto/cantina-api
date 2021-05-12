package br.com.f2e.cantina.customer.model.dto;

public class AddressInputDto {

	private String street;
	private String number;
	private String city;
	private String state;

	public AddressInputDto(String street, String number, String city, String state) {
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
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
