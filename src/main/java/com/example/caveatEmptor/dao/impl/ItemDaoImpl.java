package com.example.caveatEmptor.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.caveatEmptor.dao.ItemDao;
import com.example.caveatEmptor.model.Item;
import com.example.caveatEmptor.repositories.ItemRepository;

@Repository(value = "itemDao")
public class ItemDaoImpl extends BaseDaoImpl<Item, Long> implements ItemDao {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public JpaRepository<Item, Long> getRepository() {
		return itemRepository;
	}

}
