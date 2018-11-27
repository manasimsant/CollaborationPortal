package com.coll.dao;

import java.util.List;

import com.coll.models.Job;

public interface JobDAO {

	public boolean addJob(Job job);

	public List<Job> getAllJobs();
	public boolean updateJob(Job job);
	public boolean deleteJob(Job jobid);

}
