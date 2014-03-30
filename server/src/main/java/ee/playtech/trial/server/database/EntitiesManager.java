/*
 * Any use, copying, modification, distribution and selling of this software
 * and its documentation for any purposes without SoftwareMind's written permission
 * is hereby prohibited
 *
 */
package ee.playtech.trial.server.database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ee.playtech.trial.HibernateUtil;
import ee.playtech.trial.server.model.entity.GenericEntity;
import ee.playtech.trial.server.model.entity.ProcessedQueriesStatistics;

public class EntitiesManager {

	public void save(GenericEntity entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public <T> List<T> list(Class<T> entityClazz){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<T> entities = new ArrayList<T>();
		try {
			transaction = session.beginTransaction();
			entities.addAll(session.createCriteria(entityClazz).list());
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return entities;
	}
}
