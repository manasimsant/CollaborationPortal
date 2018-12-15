package com.coll.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.ParseException;

import com.coll.dao.JobDAO;
import com.coll.models.Job;

public class JobDAOTest {

	@Autowired
	static JobDAO jobDAO;

	@BeforeClass
	public static void setUp() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		
		jobDAO = (JobDAO) context.getBean("jobDAO");
	}
	
	@Ignore
	@Test
	public void postJobTest() throws ParseException {
		Job job= new Job();
		job.setJobTitle("HR Manager");
		job.setJobDescription("Manager for HR Deaprtment");
		job.setSalary(7000);
		
		assertEquals("Problem in posting job",true, jobDAO.addJob(job));
		
	}
	@Ignore
	@Test
	public void updateJobTest() throws ParseException {
		Job job=jobDAO.getJob(1);
		job.setSalary(10000);
		assertEquals("Problem in updating Job", true, jobDAO.updateJob(job));
		
	}
	
	
	@Test
	public void deleteJob() throws ParseException {
		Job job=jobDAO.getJob(1);
		assertEquals("Problem in deleting Job", true, jobDAO.deleteJob(job));
	}

}
