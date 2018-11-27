package com.coll.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.BlogDAO;
import com.coll.models.Blog;

public class BlogDAOTest {

	static BlogDAO blogDAO;

	@BeforeClass
	public static void setUp() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();

		blogDAO = (BlogDAO) context.getBean("blogDAO");
	}

	@Test
	public void addBlogTest() throws ParseException {
		Blog blog = new Blog();
		blog.setBlogname("Hibernate Blog");
		blog.setBlogdesc("This blog is for Hibernate Learning.");
		blog.setDate(new java.util.Date());
		blog.setLikes(0);
		blog.setDislikes(0);
		blog.setUsername("Manasi");
		blog.setStatus("NA");

		assertEquals("Problem in adding blog",true, blogDAO.addBlog(blog));
	}

	@Ignore
	@Test
	public void deleteBlogTest() {

		Blog blog = blogDAO.getBlog(1);
		assertTrue("Problem in deleting blog", blogDAO.deleteBlog(blog));
	}

	@Ignore
	@Test
	public void updateBlogTest() {
		Blog blog = blogDAO.getBlog(12);
		blog.setBlogname("Java Blog");
		assertTrue("Problem in Updating the Blog", blogDAO.updateBlog(blog));
	}

	@Ignore
	@Test
	public void listBlogTest() {
		List<Blog> listBlogs = blogDAO.listBlogs();

		assertTrue("Problem in Listing Blogs:", listBlogs.size() > 0);

		for (Blog blog : listBlogs) {
			System.out.print(blog.getBlogid() + "::");
			System.out.print(blog.getBlogname() + "::");
			System.out.println(blog.getBlogdesc() + "::");
		}
	}

	@Ignore
	@Test
	public void incrementLikes() {
		assertTrue("Problem in Incrmenting Likes", blogDAO.incrementLikes(953));
	}

	@Ignore
	@Test
	public void incrementDisLikes() {
		assertTrue("Problem in Decrementing Likes", blogDAO.incrementDisLikes(100));
	}

	@Ignore
	@Test
	public void approveBlogTest() {
		Blog blog = blogDAO.getBlog(953);
		blog.setStatus("A");
		assertTrue("Problem in Approving the Blog:", blogDAO.approveBlog(blog));
	}

	@Ignore
	@Test
	public void rejectBlogTest() {
		Blog blog = blogDAO.getBlog(100);
		blog.setStatus("NA");
		assertTrue("Problem in Rejecting the Blog:", blogDAO.rejectBlog(blog));
	}

}
