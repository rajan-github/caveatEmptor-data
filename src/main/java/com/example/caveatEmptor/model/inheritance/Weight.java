package com.example.caveatEmptor.model.inheritance;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "WEIGHT_NAME")),
		@AttributeOverride(name = "symbol", column = @Column(name = "WEIGHT_SYMBOL")) })
public class Weight extends Measurement {
	private BigDecimal value;

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
