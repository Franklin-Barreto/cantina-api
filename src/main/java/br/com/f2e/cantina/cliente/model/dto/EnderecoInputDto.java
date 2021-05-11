package br.com.f2e.cantina.cliente.model.dto;

public class EnderecoInputDto {

	private String logradouro;
	private String numero;
	private String cidade;
	private String estado;

	public EnderecoInputDto(String logradouro, String numero, String cidade, String estado) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

}
