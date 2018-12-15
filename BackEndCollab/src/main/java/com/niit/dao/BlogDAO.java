package com.niit.dao;

import java.util.List;

import com.niit.models.Blog;

public interface BlogDAO {

	public boolean addBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public List<Blog> listBlogs();
	public Blog getBlog(int blogid);
	public boolean incrementLikes(int blogid);
	public boolean incrementDisLike(int blogid);
	
	public boolean approveBlog(Blog blog);
	public boolean rejectBlog(Blog blog);
}
