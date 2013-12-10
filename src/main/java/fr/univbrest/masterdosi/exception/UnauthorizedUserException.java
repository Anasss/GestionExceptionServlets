package fr.univbrest.masterdosi.exception;

/**
 * Cette classe est 
 * @author Pierre Le Roux
 *
 */
public class UnauthorizedUserException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnauthorizedUserException() {
		super();
	}
	
	public UnauthorizedUserException(String message) {
		super(message);
	}
	
}
