package com.example.caveatEmptor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.caveatEmptor.dao.UserDao;
import com.example.caveatEmptor.model.simple.User;
import com.example.caveatEmptor.service.UserService;

@Service(value = "userService")
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public UserDao getDao() {
		return dao;
	}

}
