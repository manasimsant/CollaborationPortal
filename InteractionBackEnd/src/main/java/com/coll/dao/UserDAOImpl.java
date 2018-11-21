package com.coll.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.models.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean registerUser(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateProfile(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public User getUser(String loginname) {
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, loginname);
		session.close();
		return user;
	}

	@Override
	public User checkUserValidation(String loginname, String password) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from UserDetail where loginname=:myloginname and password=:mypassword");
		query.setParameter("myloginname", loginname);
		query.setParameter("mypassword", password);
		List<User> listUserDetail = query.list();

		if (listUserDetail.size() > 0) {
			User user = listUserDetail.get(0);
			return user;
		}

		return null;
	}

}
