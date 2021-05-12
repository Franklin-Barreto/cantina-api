package br.com.f2e.cantina.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.f2e.cantina.customer.model.Address;
import br.com.f2e.cantina.customer.model.Customer;
import br.com.f2e.cantina.customer.repository.CustomerRepository;

@DataJpaTest
class ClienteRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;
	private Customer customer;
	private Address address;

	@BeforeEach
	void inicia() {
		address = new Address("Av Osvalado Vale Cordeiro", "1360", "São Paulo", "SP");
		customer = new Customer("Franklin", "123456789", address, "11975215595");
		this.customerRepository.save(customer);
	}

	@Test
	void adicionaClienteTest() {
		assertNotNull(customer);
	}

	@Test
	void atualizaClienteTest() {
		Address endereco = new Address("Av Osvaldo Vale Cordeiro", "1360", "São Paulo", "SP");
		customer.atuaLizaEndereco(endereco);
		assertEquals("Av Osvaldo Vale Cordeiro", customer.getEndereco().getStreet());
	}

}