/*
 * Any use, copying, modification, distribution and selling of this software
 * and its documentation for any purposes without SoftwareMind's written permission
 * is hereby prohibited
 *
 */
package ee.playtech.trial.server.database;

import java.math.BigDecimal;
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
public class PlayerEntitiesManager extends EntitiesManager {

	public BalanceChangeInfo changeUserBalance(BigDecimal balanceChange,
			String userName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Transaction transaction = null;
		BalanceChangeInfo info = null;
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
			}
			player.setBalance(newBalanceAmount);
			info = new BalanceChangeInfo(player.getVersion(), balanceChange, newBalanceAmount);
			session.save(player);
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
		return info;

	}

	public List<Player> listPlayers() {
		return super.list(Player.class);
	}

}
