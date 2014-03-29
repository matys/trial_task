/*
 * Any use, copying, modification, distribution and selling of this software
 * and its documentation for any purposes without SoftwareMind's written permission
 * is hereby prohibited
 *
 */
package ee.playtech.trial.server.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import ee.playtech.trial.HibernateUtil;
import ee.playtech.trial.server.model.BalanceChangeInfo;
import ee.playtech.trial.server.model.entity.Player;

@Service
public class PlayerEntitiesManager {

	public BalanceChangeInfo changeUserBalance(BigDecimal balanceChange,
			String userName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Transaction transaction = null;
		BalanceChangeInfo info = new BalanceChangeInfo();
		try {
			transaction = session.beginTransaction();
			Player player = (Player) session.get(Player.class, userName,
					LockMode.UPGRADE);
			BigDecimal newBalanceAmount;
			if (player == null) {
				player = new Player();
				player.setUserName(userName);
				newBalanceAmount = balanceChange;
			} else {
				newBalanceAmount = player.getBalance().add(balanceChange);
				player.setBalance(newBalanceAmount);
			}
			player.setBalance(newBalanceAmount);
			session.save(player);
			transaction.commit();
			info.setVersion(player.getVersion());
			info.setCurrentBalance(newBalanceAmount);
			info.setBalanceChange(balanceChange);
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return info;

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
