package com.coll.dao;

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
			sessionFactory.getCurrentSession().update(job);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Job> getAllJobs() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Job");// HQL -> SQL
		List<Job> jobs = query.list();
		return jobs;
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

}