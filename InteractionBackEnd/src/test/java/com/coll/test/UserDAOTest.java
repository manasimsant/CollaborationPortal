package com.coll.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.ParseException;

import com.coll.dao.UserDAO;
import com.coll.models.User;

public class UserDAOTest {

	@Autowired
	static UserDAO userDAO;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Ignore
	@Test
	public void registerUserTest() throws ParseException {
		User user = new User();

		user.setLoginname("santmanasi");
		user.setPassword("pass123");
		user.setUsername("Manasisant");
		user.setEmail("manasisant@gmail.com");
		user.setMobileno("9997819991");
		user.setAddress("Mumbai");
		user.setRole("ROLE_USER");

		assertEquals("Problem in adding users", true, userDAO.registerUser(user));
	}


	@Test
	public void updateUserTest() {
		User user = userDAO.getUser("Manasi Sant");
		user.setEmail("manalisant@hotmail.com");
		assertEquals("Problem in updating the User", userDAO.updateProfile(user));
	}

	@Ignore
	@Test
	public void checkUserTest() {
		User user = userDAO.checkUserValidation("Manasi", "password");
		assertNotNull("Problem in Checking User", user);
	}

}
