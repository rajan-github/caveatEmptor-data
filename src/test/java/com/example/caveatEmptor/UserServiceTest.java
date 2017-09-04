package com.example.caveatEmptor;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.caveatEmptor.model.advanced.Address;
import com.example.caveatEmptor.model.simple.User;
import com.example.caveatEmptor.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Autowired
//	private AddressService addressService;

	@Test
	public void saveTest() {
		User user = new User("Johndoe");
		Address address = new Address("Some Street 123", "12345", "Some City");
		user.setShippingAddress(address);
		userService.deleteAll();
		user = userService.save(user);
		User newUser = userService.findOne(user.getId());
		assertNotNull(newUser);
		assertEquals(user.getId(), newUser.getId());
	}

	@After
	@Test
	public void clearDatabase() {
		userService.deleteAll();
	}
}
