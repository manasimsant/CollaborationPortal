package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.BlogDAO;
import com.niit.models.Blog;

@Transactional
@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		} catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	@Override
	public List<Blog> listBlogs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog");
		List<Blog> listBlogs=query.list();
		return listBlogs;

	}

	@Override
	public Blog getBlog(int blogid) {
		Session session=sessionFactory.openSession();
		Blog blog=(Blog)session.get(Blog.class,blogid);
		session.close();
		return blog;
	
	}

	@Override
	public boolean incrementLikes(int blogid) {
		try
		{
			Blog blog =this.getBlog(blogid);
			blog.setLikes(blog.getLikes()+1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}

	}

	@Override
	public boolean incrementDisLike(int blogid) {
		try
		{
			Blog blog =this.getBlog(blogid);
			blog.setDislike(blog.getDislike()+1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}

	}

	@Override
	public boolean approveBlog(Blog blog) {
		try {
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean rejectBlog(Blog blog) {
		try {
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

}
