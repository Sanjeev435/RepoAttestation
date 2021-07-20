package com.rbs.repoattestation.exception;

/**
 * Custom exception class for CSV Reader
 */
public class CsvReaderException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public CsvReaderException(String message) {
		super(message);
	}

}
