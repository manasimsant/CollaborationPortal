package com.niit.tests;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.ParseException;

import com.niit.dao.BlogDAO;
import com.niit.models.Blog;

public class BlogTest {

	@Autowired
	static BlogDAO blogDAO;

	@BeforeClass
	public static void setUp() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		blogDAO = (BlogDAO) context.getBean("blogDAO");
	}

	@Test
	public void insertBlogTest() throws ParseException {
		Blog blog = new Blog();
		blog.setBlogname("Java Blog");
		blog.setBlogdesc("Blog for Java.");
		blog.setCreatedate(new Date());
		blog.setLoginname("manya@gmail.com");
		blog.setLikes(12);
		blog.setDislike(1);

		assertEquals("Problem in inserting blogs", true, blogDAO.addBlog(blog));
	}

	@Ignore
	@Test
	public void deleteBlogTest() {
		Blog blog = blogDAO.getBlog(1);
		assertEquals("Problem in deleting blog", true, blogDAO.deleteBlog(blog));
	}
	
	@Ignore
	@Test
	public void updateBlogTest() {
		Blog blog=blogDAO.getBlog(1);
		blog.setBlogdesc("This blog is only for core Java learning");
		assertEquals("Problem in updating blog", true, blogDAO.updateBlog(blog));
	}
	
	@Ignore
	@Test
	public void listBlogsTest() {
		
		List<Blog> listBlogs=blogDAO.listBlogs();
		assertEquals("Problem in listing blogs", true, listBlogs.size()>0);
		
		for(Blog blog: listBlogs) {
			System.out.println(blog.getBlogid()+ ":::");
			System.out.println(blog.getBlogname()+":::");
			System.out.println(blog.getBlogdesc()+":::");
		}
	}
	@Ignore
	@Test
	public void approveBlogTest() {
		Blog blog=blogDAO.getBlog(102);
		blog.setStatus("A");
		assertEquals("Problem in approving blog.", true, blogDAO.approveBlog(blog));
	}
	
	@Ignore
	@Test
	public void rejectBlogTest() {
		Blog blog=blogDAO.getBlog(1);
		blog.setStatus("NA");
		assertEquals("Problem in rejecting Blog.",true, blogDAO.rejectBlog(blog));
	}
}
