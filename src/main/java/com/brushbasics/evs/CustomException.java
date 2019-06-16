package com.brushbasics.evs;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception {

	/**
	 * 
	 */

	private static final long serialVersionUID = -1102577956890084829L;


	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}

}
