package com.niit.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.UserDAO;
import com.coll.models.User;

@RestController
public class UserRestController {

	@Autowired
	UserDAO userDAO;

	@PostMapping("/registerUser")
	public ResponseEntity<User> registerUser(@RequestBody User user, HttpSession session) {

		if (userDAO.registerUser(user)) {
			return new ResponseEntity<User>(HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/checkUser")
	public ResponseEntity<User> checkLogin(@RequestBody User User,HttpSession session)
	{
		User User1=userDAO.checkUserValidation(User.getLoginname(), User.getPassword());
		if(User1!=null)
		{
			session.setAttribute("User", User1);
			return new ResponseEntity<User>(User1,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<User>(User1,HttpStatus.CONFLICT);
		}
		
	}
	
}
