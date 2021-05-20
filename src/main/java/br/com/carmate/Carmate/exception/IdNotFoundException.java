package br.com.carmate.Carmate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class IdNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public IdNotFoundException(String exception) {
		super(exception);
	}

}
