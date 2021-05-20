package br.com.carmate.Carmate.exception;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName(value = "error")
public class ErrorBodyResponse {
	
	public ErrorBodyResponse(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}
	
	private String message;
	  
	private List<String> details;


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public List<String> getDetails() {
		return details;
	}


	public void setDetails(List<String> details) {
		this.details = details;
	}
	
	
	 

	
}
