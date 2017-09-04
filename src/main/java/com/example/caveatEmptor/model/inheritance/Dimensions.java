package com.example.caveatEmptor.model.inheritance;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "DIMENSIONS_NAME")),
		@AttributeOverride(name = "symbol", column = @Column(name = "DIMENSIONS_SYMBOL")) })
public class Dimensions extends Measurement {
	@NotNull
	protected BigDecimal depth;
	@NotNull
	protected BigDecimal height;
	@NotNull
	protected BigDecimal width;
}
