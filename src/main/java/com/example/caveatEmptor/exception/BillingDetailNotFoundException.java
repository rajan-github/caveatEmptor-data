package com.example.caveatEmptor.exception;

public class BillingDetailNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long billingDetailId;

	public BillingDetailNotFoundException(Long billingDetailId) {
		super();
		this.billingDetailId = billingDetailId;
	}

	public Long getBillingDetailId() {
		return billingDetailId;
	}

}
