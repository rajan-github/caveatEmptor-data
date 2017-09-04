package com.example.caveatEmptor.model.inheritance;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Measurement {
	@NotNull
	protected String name;

	@NotNull
	protected String symbol;
}
