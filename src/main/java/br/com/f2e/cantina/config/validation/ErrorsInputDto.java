package br.com.f2e.cantina.config.validation;

public class ErrorsInputDto {

	private String field;
	private String message;

	public ErrorsInputDto(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}

}
