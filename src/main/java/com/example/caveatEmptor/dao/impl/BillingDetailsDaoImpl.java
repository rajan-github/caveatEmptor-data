package com.example.caveatEmptor.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.caveatEmptor.dao.BillingDetailsDao;
import com.example.caveatEmptor.model.inheritance.BillingDetails;
import com.example.caveatEmptor.repositories.BillingDetailsRepository;

@Repository
public class BillingDetailsDaoImpl extends BaseDaoImpl<BillingDetails, Long> implements BillingDetailsDao {

	@Autowired
	private BillingDetailsRepository billingDetailsRepository;

	@Override
	public JpaRepository<BillingDetails, Long> getRepository() {
		return billingDetailsRepository;
	}

}
