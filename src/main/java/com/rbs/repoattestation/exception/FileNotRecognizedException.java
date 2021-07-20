package com.rbs.repoattestation.exception;

/**
 * Custom exception class for CSV file locater errors
 */
public class FileNotRecognizedException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public FileNotRecognizedException(String message) {
		super(message);
	}

}
