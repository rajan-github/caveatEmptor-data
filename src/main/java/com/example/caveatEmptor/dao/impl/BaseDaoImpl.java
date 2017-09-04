package com.example.caveatEmptor.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.example.caveatEmptor.dao.BaseDao;

public abstract class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {
	public T save(T entity) {
		return getRepository().save(entity);
	}

	@Override
	public void delete(T entity) {
		getRepository().delete(entity);
	}

	@Override
	public T findOne(ID id) {
		return getRepository().findOne(id);
	}

	@Override
	public void deleteAll() {
		getRepository().deleteAll();
	}

	@Override
	public List<T> findAll() {
		return getRepository().findAll();
	}

}
