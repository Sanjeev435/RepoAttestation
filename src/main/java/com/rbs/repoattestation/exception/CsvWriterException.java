package com.rbs.repoattestation.exception;

/**
 * Custom exception class for CSV Writer
 */
public class CsvWriterException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public CsvWriterException(String message) {
		super(message);
	}

}
