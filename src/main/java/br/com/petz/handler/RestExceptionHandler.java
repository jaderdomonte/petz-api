package br.com.petz.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.petz.exception.ResourceNotFoundError;
import br.com.petz.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException rnfeException){
		ResourceNotFoundError error = buildResourceNotFoundError(rnfeException);
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	private ResourceNotFoundError buildResourceNotFoundError(ResourceNotFoundException rnfeException) {
		return ResourceNotFoundError.builder()
									.title("Recurso Não Encontrado")
									.status(HttpStatus.NOT_FOUND.value())
									.details(rnfeException.getMessage())
									.date(new Date().getTime())
									.message(rnfeException.getClass().getName())
									.build();
		
	}
}
