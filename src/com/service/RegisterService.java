package com.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.hibernate.util.HibernateUtil;
import com.model.User;

public class RegisterService {

	public boolean register(User user) {
		Session session = HibernateUtil.openSession();
		//if (isUserExists(user))
		//	return false;

		Transaction transaction = null;
		try {
			transaction = session.getTransaction();
			transaction.begin();
			//session.save(user);
			session.saveOrUpdate(user);
			transaction.commit();
		} catch (ConstraintViolationException cve) {
			return false;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean isUserExists(User user) {
		Session session = HibernateUtil.openSession();
		boolean result = false;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from registration where email='" + user.getEmail() + "'");
			User u = (User) query.uniqueResult();
			tx.commit();
			if (u != null)
				result = true;
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			return false;
		} finally {
			session.close();
		}
		return result;
	}
}