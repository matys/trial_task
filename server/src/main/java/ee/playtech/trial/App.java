package ee.playtech.trial;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ee.playtech.trial.server.model.entity.Player;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + HSQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		App app = new App();
		app.saveContact("Jiya");
		app.saveContact("Manisha");
		app.saveContact("Riya");
		app.listContact();
	}

	public Integer saveContact(String contactName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Integer contactId = null;
		Transaction transaction = null;
//		try {
//			transaction = session.beginTransaction();
//			Player contact = new Player();
//			contact.setUserName(contactName);
//			contactId = (Integer) session.save(contact);
//			transaction.commit();
//		} catch (HibernateException e) {
//			transaction.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
		return contactId;
	}

	public void listContact() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
//		try {
//			transaction = session.beginTransaction();
//			@SuppressWarnings("unchecked")
//			List<Player> contactList = session.createQuery("from Contact")
//					.list();
//			for (Iterator<Player> iterator = contactList.iterator(); iterator
//					.hasNext();) {
//				Player contact = (Player) iterator.next();
//				System.out.println(contact.getUserName());
//			}
//			transaction.commit();
//		} catch (HibernateException e) {
//			transaction.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
	}

}