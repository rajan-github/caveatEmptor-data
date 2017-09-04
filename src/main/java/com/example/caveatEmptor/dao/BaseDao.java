package com.example.caveatEmptor.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseDao<T, ID extends Serializable> {
	public abstract JpaRepository<T, ID> getRepository();

	public abstract T save(T entity);

	public abstract void delete(T entity);

	public abstract T findOne(ID id);

	public abstract void deleteAll();

	public abstract List<T> findAll();
}
