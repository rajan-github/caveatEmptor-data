package com.example.caveatEmptor.model.inheritance;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class BankAccount extends BillingDetails {
	@NotNull
	protected String account;
	@NotNull
	protected String bankName;
	@NotNull
	protected String swift;
}
