package com.example.caveatEmptor.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.caveatEmptor.dao.ShipmentDao;
import com.example.caveatEmptor.model.advanced.Shipment;
import com.example.caveatEmptor.repositories.ShipmentRepository;

@Repository(value = "shipmentDao")
public class ShipmentDaoImpl extends BaseDaoImpl<Shipment, Long> implements ShipmentDao {

	@Autowired
	private ShipmentRepository shipmentRepository;

	@Override
	public JpaRepository<Shipment, Long> getRepository() {
		return shipmentRepository;
	}

}
