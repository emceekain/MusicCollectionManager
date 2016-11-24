package main.java.exceptions;

public class DAOException extends RuntimeException {
	private String message;
	private Throwable cause;
	
	public DAOException(String message){
		this.message = message;
	}
	
	public DAOException(String message, Throwable cause){
		this.message = message;
		this.cause=cause;
	}

	public String getMessage() {
		return message;
	}

	public Throwable getCause() {
		return cause;
	}
	
}
