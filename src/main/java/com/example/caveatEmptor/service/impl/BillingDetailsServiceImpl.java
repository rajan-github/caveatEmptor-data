package com.example.caveatEmptor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.caveatEmptor.dao.BillingDetailsDao;
import com.example.caveatEmptor.model.inheritance.BillingDetails;
import com.example.caveatEmptor.service.BillingDetailsService;

@Service
public class BillingDetailsServiceImpl extends BaseServiceImpl<BillingDetails, Long> implements BillingDetailsService {

	@Autowired
	private BillingDetailsDao billingDetailsDao;

	@Override
	public BillingDetailsDao getDao() {
		return billingDetailsDao;
	}

}
