package org.senssic.exception;

public class BussnessException extends Exception {

	private static final long serialVersionUID = 1L;

	public BussnessException(String msg, Exception e) {
		super(msg, e);
	}

}
