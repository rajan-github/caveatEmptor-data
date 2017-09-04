package com.example.caveatEmptor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.caveatEmptor.dao.BaseDao;
import com.example.caveatEmptor.dao.ItemDao;
import com.example.caveatEmptor.model.Item;
import com.example.caveatEmptor.service.ItemService;

@Service(value = "itemService")
public class ItemServiceImpl extends BaseServiceImpl<Item, Long> implements ItemService {

	@Autowired
	private ItemDao itemDao;

	@Override
	public BaseDao<Item, Long> getDao() {
		return itemDao;
	}

}
