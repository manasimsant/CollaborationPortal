package com.coll.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.ParseException;

import com.coll.dao.BlogCommentDAO;
import com.coll.models.BlogComment;

public class BlogCommentDAOTest {

	@Autowired
	static BlogCommentDAO blogCommentDAO;

	@BeforeClass
	public static void setUp() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();

		blogCommentDAO = (BlogCommentDAO) context.getBean("blogCommentDAO");
	}

	@Ignore
	@Test
	public void addCommentTest() throws ParseException {
		BlogComment comment = new BlogComment();
		comment.setCommentid(12);
		comment.setCtext("Its very intresting");
		comment.setLoginname("Sushant");
		comment.setCommentdate(new java.util.Date());

		assertEquals("Problem in adding Comment", true, blogCommentDAO.addComment(comment));
	}

	
	@Test
	public void deleteCommentTest() {
		BlogComment comment = blogCommentDAO.getBlogComment(1);
		assertEquals("Problem in deleting the Comment:", true, blogCommentDAO.deleteComment(comment));
	}

	@Ignore
	@Test
	public void listCommentsTest() {
		List<BlogComment> listBlogComments = blogCommentDAO.listBlogComments(953);

		assertEquals("Problem in Listing Blog Comments", true, listBlogComments.size() > 0);

		for (BlogComment comment : listBlogComments) {
			System.out.print(comment.getCommentid() + ":::");
			System.out.print(comment.getCtext() + ":::");
			System.out.println(comment.getLoginname() + ":::");
		}
	}

}
