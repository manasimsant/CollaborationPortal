package com.niit.tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.ParseException;

import com.niit.dao.JobDAO;
import com.niit.models.Job;

public class JobTest {

	@Autowired
	static JobDAO jobDAO;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		jobDAO = (JobDAO) context.getBean("jobDAO");
	}
	
	@Test
	public void postJobTest() throws ParseException {
		Job job=new Job();
		job.setCompanyname("Cognizant");
		job.setDesignation("Developer");
		job.setExperience(3);
		job.setJobdesc("Developer Job");
		assertEquals("Problem in posting Job", true, jobDAO.postJob(job));
	}
}
