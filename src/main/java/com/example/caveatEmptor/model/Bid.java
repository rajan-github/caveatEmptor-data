package com.example.caveatEmptor.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Bid {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	private BigDecimal amount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	@org.hibernate.annotations.CreationTimestamp
	private Date createdOn;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ITEM_ID", nullable = false)
	private Item item;

	public Bid() {
		super();
	}

	public Bid(BigDecimal amount) {
		super();
		this.amount = amount;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
