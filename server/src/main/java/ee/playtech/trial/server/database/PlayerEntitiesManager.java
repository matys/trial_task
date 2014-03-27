/*
 * Any use, copying, modification, distribution and selling of this software
 * and its documentation for any purposes without SoftwareMind's written permission
 * is hereby prohibited
 *
 */
package ee.playtech.trial.server.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import sun.net.www.content.text.plain;
import ee.playtech.trial.HibernateUtil;
import ee.playtech.trial.server.model.entity.Player;

import org.springframework.stereotype.Service;

@Service
public class PlayerEntitiesManager {

	public BigDecimal changeUserBalance(BigDecimal balanceChange,
			String userName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Transaction transaction = null;
		BigDecimal newBalanceAmount = null;
		try {
			transaction = session.beginTransaction();
			Player player = (Player) session.get(Player.class, userName,
					LockMode.UPGRADE);
			if (player == null) {
				player = new Player();
				player.setUserName(userName);
				player.setBalance(balanceChange);
			} else {
				newBalanceAmount = player.getBalance().add(balanceChange);
				player.setBalance(newBalanceAmount);
			}
			session.save(player);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newBalanceAmount;

	}

	public List<Player> listPlayers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Player> playerList = new ArrayList<Player>();
		try {
			transaction = session.beginTransaction();
			playerList.addAll(session.createQuery("from Player")
					.list());
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return playerList;
	}

}
