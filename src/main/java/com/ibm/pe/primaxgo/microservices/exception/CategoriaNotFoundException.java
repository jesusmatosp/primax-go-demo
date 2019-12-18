package com.ibm.pe.primaxgo.microservices.exception;

public class CategoriaNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CategoriaNotFoundException(String message) {
		super(message);
	}
	
	public CategoriaNotFoundException(String message, Throwable t) {
		super(message, t);
	}
	
}
