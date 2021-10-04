package br.newtonpaiva.livro.controller.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.newtonpaiva.livro.exception.NotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(value = { NotFoundException.class })
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public Map<String, Object> notFoundException(NotFoundException exception) {
		Map<String, Object> result = new HashMap<>();
		result.put("errorMessage", exception.getMessage());
		return result;
	}
	
}
