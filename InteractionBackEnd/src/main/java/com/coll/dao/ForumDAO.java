package com.coll.dao;

import java.util.List;

import com.coll.models.Forum;

public interface ForumDAO {
	public boolean addForum(Forum forum);
	public boolean updateForum(Forum forum);
	public boolean deleteForum(Forum forumid);
	public Forum getForum(int forumid);
	public List <Forum> listForum();

}
