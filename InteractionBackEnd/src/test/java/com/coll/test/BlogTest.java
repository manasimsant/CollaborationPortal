package com.coll.test;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.BlogDAO;
import com.coll.models.Blog;

public class BlogTest {

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		BlogDAO blogDAO = (BlogDAO) context.getBean("BlogDAO");
	}
	
	public void addBlogtest() {
		Blog blog=new Blog();
		blog.setBlogid(01);
		blog.setBlogname("Hibernate blog");
		blog.setBlogdesc("This is HIbernate blog");
		blog.setLikes(2);
		blog.setDislikes(1);
		blog.setStatus("Checked");
	}

}
