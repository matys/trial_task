package ee.playtech.trial;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ee.playtech.trial.server.model.entity.Player;

/**
 * Hello world!
 * 
 */
public class ServeerApp {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + HSQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		ServeerApp app = new ServeerApp();
		System.out.println("a");
		app.saveContact("Jiya");
		System.out.println("b");
		app.saveContact("Manisha");
		System.out.println("a");
		app.saveContact("Riya");
		System.out.println("b");
		app.listContact();
	}

	public String saveContact(String contactName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String contactId = null;
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Player contact = new Player();
			contact.setUserName(contactName);
			contactId = (String) session.save(contact);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return contactId;
	}

	public void listContact() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Player> contactList = session.createQuery("from Player")
					.list();
			System.out.println(contactList.size());
			for (Iterator<Player> iterator = contactList.iterator(); iterator
					.hasNext();) {
				Player contact = (Player) iterator.next();
				System.out.println(contact.getUserName());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}