package com.coll.dao;

import java.util.List;

import com.coll.models.Blog;

public interface BlogDAO {

	public boolean addBlog(Blog blog);

	public boolean updateBlog(Blog blog);

	public boolean deleteBlog(Blog blog);

	public Blog getBlog(int blogid);

	public List<Blog> listBlogs();

	public boolean incrementLikes(int blogid);

	public boolean incrementDisLikes(int blogid);

	public boolean approveBlog(Blog blog);

	public boolean rejectBlog(Blog blog);

}
