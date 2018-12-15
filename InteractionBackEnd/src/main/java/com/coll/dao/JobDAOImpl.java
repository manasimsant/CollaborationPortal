package com.coll.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.models.Job;

@Transactional
@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	public JobDAOImpl(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public boolean addJob(Job job) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(job);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Job> getAllJobs() {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<Job> jobList = new ArrayList<Job>();
			Query query = session.createQuery("FROM Job");
			jobList = query.list();
			return jobList;
		} catch (Exception e) {
			return null;
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
	public boolean deleteJob(Job jobid) {
		try {
			sessionFactory.getCurrentSession().delete(jobid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Job getJob(int jobid) {
		try {
			Session session = sessionFactory.openSession();
			Job job = session.get(Job.class, jobid);
			return job;
		} catch (Exception e) {
			return null;
		}
	}
}