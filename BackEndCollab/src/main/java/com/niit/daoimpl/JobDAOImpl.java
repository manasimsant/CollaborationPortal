package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.JobDAO;
import com.niit.models.Job;

@Transactional
@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean postJob(Job job) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateJob(Job job) {
		try {
			sessionFactory.getCurrentSession().update(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Job> listJobDetails() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from user");
		List<Job> listJobs = query.list();
		return listJobs;
	}

	@Override
	public Job getJob(int jobid) {
		Session session = sessionFactory.openSession();
		Job job = (Job) session.get(Job.class, jobid);
		session.close();
		return job;
	}

}
