package com.coll.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.ParseException;

import com.coll.dao.UserDAO;
import com.coll.models.User;

public class UserDAOTest {

	static UserDAO userDAO;
	
	@BeforeClass
	public static void setUp()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}

	@Test
	public void registerUserTest() throws ParseException
	{
		User user=new User();
		
		user.setLoginname("sudhir");
		user.setPassword("pass123");
		user.setUsername("Sudhir Kashyap");
		user.setEmail("sudhir@gmail.com");
		user.setMobileno("9997819991");
		user.setAddress("Mumbai");
		user.setRole("ROLE_USER");
		
		assertEquals("Problem in Registering the User:", true, userDAO.registerUser(user));
	}
	@Ignore
	@Test
	public void updateUserTest()
	{
		User user=userDAO.getUser("sudhir");
		user.setEmail("sudhir_kashyap@gmail.com");
		assertEquals("Problem in updating the User",userDAO.updateProfile(user));
	}
	@Ignore
	@Test
	public void checkUserTest()
	{
		User user=userDAO.checkUserValidation("sudhir", "pass23");
		assertNotNull("Problem in Checking User",user);
	}

}
