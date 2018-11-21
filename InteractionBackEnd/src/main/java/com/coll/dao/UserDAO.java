package com.coll.dao;

import com.coll.models.User;

public interface UserDAO {

	public boolean registerUser(User user);

	public boolean updateProfile(User user);

	public User getUser(String loginname);

	public User checkUserValidation(String loginname, String password);

}
