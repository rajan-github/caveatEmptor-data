package com.example.caveatEmptor.exception;

public class UserNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;

	public UserNotFoundException(Long userId) {
		super();
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}

}
