package com.example.caveatEmptor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.caveatEmptor.dao.BaseDao;
import com.example.caveatEmptor.dao.ShipmentDao;
import com.example.caveatEmptor.model.advanced.Shipment;
import com.example.caveatEmptor.service.ShipmentService;

@Service(value = "shipmentService")
public class ShipmentServiceImpl extends BaseServiceImpl<Shipment, Long> implements ShipmentService {

	@Autowired
	private ShipmentDao shipmentDao;

	@Override
	public BaseDao<Shipment, Long> getDao() {
		return shipmentDao;
	}

}
