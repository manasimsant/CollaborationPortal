package com.coll.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.ParseException;

import com.coll.dao.ForumDAO;
import com.coll.models.Forum;

public class ForumDAOTest {

	@Autowired
	static ForumDAO forumDAO;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();

		forumDAO = (ForumDAO) context.getBean("forumDAO");

	}

	@Ignore
	@Test
	public void addForum() throws ParseException {
		Forum forum = new Forum();
		forum.setForumdesc(" description");
		forum.setForumname("manasi forum");
		forum.setUsername("manasisant@gmail.com");
		forum.setCreateforumdate(new Date());
		assertEquals("Problem in adding forum", true, forumDAO.addForum(forum));
	}

	
	@Test
	public void updateForum() throws ParseException {

		Forum forum = forumDAO.getForum(1);
		forum.setForumname("Hibernate forum");
		assertEquals("Problem in updating forum", true, forumDAO.updateForum(forum));
	}

}
