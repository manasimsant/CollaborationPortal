package com.coll.dao;

import java.util.List;

public interface ForumComment {

	public boolean addForumComment(ForumComment comment);

	public boolean updateForumComment(ForumComment comment);

	public boolean deleteComment(ForumComment comment);

	public List<ForumComment> listForumComments();

	public ForumComment getForumComments(int commentid);

}
