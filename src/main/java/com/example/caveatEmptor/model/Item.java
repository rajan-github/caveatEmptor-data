package com.example.caveatEmptor.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.caveatEmptor.itemType.AuctionType;
import com.example.caveatEmptor.model.inheritance.Dimensions;
import com.example.caveatEmptor.model.inheritance.Weight;

@Entity
@Access(AccessType.FIELD)
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@NotNull
	@Size(min = 2, max = 255, message = "Name is required, maximum 255 characters.")
	protected String name;
	protected String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable = false)
	@org.hibernate.annotations.Generated(org.hibernate.annotations.GenerationTime.ALWAYS)
	protected Date lastModified;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	@org.hibernate.annotations.CreationTimestamp
	protected Date createdOn;

	protected boolean verified;

	@NotNull
	@Enumerated(EnumType.STRING)
	protected AuctionType auctionType;

	@Column(insertable = false)
	@org.hibernate.annotations.ColumnDefault("1.00")
	@org.hibernate.annotations.Generated(org.hibernate.annotations.GenerationTime.INSERT)
	protected BigDecimal initialPrice;

	protected Date auctionStart;

	@Future
	protected Date auctionEnd;

	@OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@org.hibernate.annotations.OnDelete(action = org.hibernate.annotations.OnDeleteAction.CASCADE)
	protected Set<Bid> bids = new HashSet<>();

	@Embedded
	protected Dimensions dimensions;

	@Embedded
	protected Weight weight;

	public Item() {
		super();
	}

	public Item(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public AuctionType getAuctionType() {
		return auctionType;
	}

	public void setAuctionType(AuctionType auctionType) {
		this.auctionType = auctionType;
	}

	public BigDecimal getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(BigDecimal initialPrice) {
		this.initialPrice = initialPrice;
	}

	public Date getAuctionStart() {
		return auctionStart;
	}

	public void setAuctionStart(Date auctionStart) {
		this.auctionStart = auctionStart;
	}

	public Date getAuctionEnd() {
		return auctionEnd;
	}

	public void setAuctionEnd(Date auctionEnd) {
		this.auctionEnd = auctionEnd;
	}

	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	public void addBid(Bid bid) {
		if (bid == null)
			throw new NullPointerException("Can't add null bid!");
		if (bid.getItem() != null)
			throw new IllegalStateException("Bid is already assigned to an Item!");
		getBids().add(bid);
		bid.setItem(this);
	}

	public Date getLastModified() {
		return lastModified;
	}

	public Dimensions getDimensions() {
		return dimensions;
	}

	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight;
	}

}
