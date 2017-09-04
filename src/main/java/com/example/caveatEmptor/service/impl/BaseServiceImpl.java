package com.example.caveatEmptor.service.impl;

import java.io.Serializable;
import java.util.List;

import com.example.caveatEmptor.service.BaseService;

public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

	@Override
	public T save(T entity) {
		return getDao().save(entity);
	}

	@Override
	public void delete(T entity) {
		getDao().delete(entity);
	}

	@Override
	public T findOne(ID id) {
		return getDao().findOne(id);
	}

	@Override
	public void deleteAll() {
		getDao().deleteAll();
	}

	@Override
	public List<T> findAll() {
		return getDao().findAll();
	}

}
