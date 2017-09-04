package com.example.caveatEmptor.service;

import java.io.Serializable;
import java.util.List;

import com.example.caveatEmptor.dao.BaseDao;

public interface BaseService<T, ID extends Serializable> {
	public abstract BaseDao<T, ID> getDao();

	public abstract T save(T entity);

	public abstract void delete(T entity);

	public abstract T findOne(ID id);

	public abstract void deleteAll();

	public abstract List<T> findAll();

}
