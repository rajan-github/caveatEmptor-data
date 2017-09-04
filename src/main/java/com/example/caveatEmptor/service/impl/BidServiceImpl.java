package com.example.caveatEmptor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.caveatEmptor.dao.BaseDao;
import com.example.caveatEmptor.dao.BidDao;
import com.example.caveatEmptor.model.Bid;
import com.example.caveatEmptor.service.BidService;

@Service(value = "bidService")
public class BidServiceImpl extends BaseServiceImpl<Bid, Long> implements BidService {

	@Autowired
	private BidDao bidDao;

	@Override
	public BaseDao<Bid, Long> getDao() {
		return bidDao;
	}

}
