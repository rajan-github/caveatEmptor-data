package com.example.caveatEmptor.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.caveatEmptor.dao.BidDao;
import com.example.caveatEmptor.model.Bid;
import com.example.caveatEmptor.repositories.BidRepository;

@Repository(value = "bidDao")
public class BidDaoImpl extends BaseDaoImpl<Bid, Long> implements BidDao {

	@Autowired
	private BidRepository bidRepository;

	@Override
	public JpaRepository<Bid, Long> getRepository() {
		return bidRepository;
	}

}
