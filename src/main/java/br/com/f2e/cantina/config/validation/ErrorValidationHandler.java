package br.com.f2e.cantina.config.validation;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorValidationHandler {

	@Autowired
	private MessageSource messageSorce;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorsInputDto> badRequestHandler(MethodArgumentNotValidException exception) {
		return exception.getFieldErrors().stream().map(error -> {
			String message = messageSorce.getMessage(error, LocaleContextHolder.getLocale());
			return new ErrorsInputDto(error.getField(), message);
		}).collect(Collectors.toList());
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public String notFoundHandler(NoSuchElementException exception) {
		return exception.getMessage();
	}
}
