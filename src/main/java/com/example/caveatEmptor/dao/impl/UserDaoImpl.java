package com.example.caveatEmptor.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.caveatEmptor.dao.UserDao;
import com.example.caveatEmptor.model.simple.User;
import com.example.caveatEmptor.repositories.UserRepository;

@Repository(value = "userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {

	@Autowired
	private UserRepository userRepository;

	@Override
	public JpaRepository<User, Long> getRepository() {
		return userRepository;
	}

}
