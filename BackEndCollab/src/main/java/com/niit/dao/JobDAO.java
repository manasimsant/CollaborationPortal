package com.niit.dao;

import java.util.List;

import com.niit.models.Job;

public interface JobDAO {
	public boolean postJob(Job job);
	public boolean updateJob(Job job);
	public List<Job> listJobDetails();
	public Job getJob(int jobid);

}
