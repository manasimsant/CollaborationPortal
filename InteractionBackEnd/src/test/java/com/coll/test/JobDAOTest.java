/*package com.coll.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.ParseException;

import com.coll.dao.JobDAO;
import com.coll.models.Job;

public class JobDAOTest {

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
		job.setJob_name("HR Manager");
		job.setJob_desc("Manager for HR department");
		job.setSalary(7000);
		
		assertEquals("Problem in posting job",true, jobDAO.postJob(job));
		
	}
	
	@Test
	public void updateJobTest() throws ParseException {
		Job job=jobDAO.getJob(1);
		job.setSalary(10000);
		assertEquals("Problem in updating Job", true, jobDAO.updateJob(job));
		
	}
}
*/