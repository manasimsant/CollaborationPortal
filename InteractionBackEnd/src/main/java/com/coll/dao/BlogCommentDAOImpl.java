package com.coll.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.models.BlogComment;

@Transactional
@Repository("blogCommentDAO")
public class BlogCommentDAOImpl implements BlogCommentDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addComment(BlogComment comment) {
		try {

			sessionFactory.getCurrentSession().saveOrUpdate(comment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteComment(BlogComment comment) {
		try {
			sessionFactory.getCurrentSession().delete(comment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public BlogComment getBlogComment(int commentid) {
		Session session = sessionFactory.openSession();
		BlogComment comment = session.get(BlogComment.class, commentid);
		session.close();
		return comment;
	}

	@Override
	public List<BlogComment> listBlogComments(int blogid) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from * BlogComment");
		List<BlogComment> listBlogComments=query.list();
		return listBlogComments;
	}

}
