package com.example.caveatEmptor.model.advanced;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.example.caveatEmptor.model.Item;

@Entity
public class Shipment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "ITEM_SHIPMENT", joinColumns = @JoinColumn(name = "SHIPMENT_ID"), inverseJoinColumns = @JoinColumn(name = "ITEM_ID", nullable = false, unique = true))
	private Item auction;

	public Shipment() {
		super();
	}

	public Shipment(Item auction) {
		super();
		this.auction = auction;
	}

}
