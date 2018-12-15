package com.coll.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.models.ProfilePicture;

@Repository("profilepictureDAO")
public class ProfilePictureDAOImpl implements ProfilePictureDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(ProfilePicture profilepicture) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProfilePicture getProfilePicture(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
