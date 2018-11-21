package com.coll.dao;

import java.util.List;

import com.coll.models.BlogComment;

public interface BlogCommentDAO {
	
	public boolean addComment(BlogComment comment);
	public boolean deleteComment(BlogComment comment);
	public BlogComment getBlogComment(int commentid);
	public List<BlogComment> listBlogComments(int blogid);

}
