package com.coll.dao;

import com.coll.models.ProfilePicture;

public interface ProfilePictureDAO {
	
	public void save(ProfilePicture profilepicture);
	public ProfilePicture getProfilePicture(String username);

}
