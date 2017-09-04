package com.example.caveatEmptor.model.inheritance;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class CreditCard extends BillingDetails {

	@NotNull
	protected String cardNumber;
	@NotNull
	protected String expMonth;
	@NotNull
	protected String expYear;
}
