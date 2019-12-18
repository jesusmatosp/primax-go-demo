package com.ibm.pe.primaxgo.microservices.exception;


public class CategoriaParamEmptyException extends Exception {

	private static final long serialVersionUID = 1L;

	public CategoriaParamEmptyException(String message) {
		super(message);
	}
	
	public CategoriaParamEmptyException(String message, Throwable t) {
		super(message, t);
	}
	
}
