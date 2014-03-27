/*
 * Any use, copying, modification, distribution and selling of this software
 * and its documentation for any purposes without SoftwareMind's written permission
 * is hereby prohibited
 *
 */
package ee.playtech.trial.server.ws.rest;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import ee.playtech.trial.server.database.PlayerEntitiesManager;
import ee.playtech.trial.server.model.entity.Player;

/**
 * Created with IntelliJ IDEA. User: Mateusz Date: 15.04.13 Time: 20:27
 */
@Path("/")
public class UserBalanceWebservice {

	private PlayerEntitiesManager playerEntitiesManager = new PlayerEntitiesManager();
	
	/**
	 * example: http://localhost:9999/TestUser/balanceChange/
	 * 
	 * {"transactionId" : 22, "amount" :22}
	 * 
	 * another solution could be to create PUT method. However, for PUT method
	 * more accurate would be /{userName}/balance/ parameterized with new
	 * balance amount value.
	 * 
	 */
	@POST
	@Path("/{userName}/balanceChange/")
	@Consumes("application/json")
	@Produces("application/json")
	public Employee addBalanceChange(@PathParam("userName") String userName,
			String jsonRequest) {
		if(playerEntitiesManager == null) {
			System.out.println("____0000 null");
		}
		playerEntitiesManager.changeUserBalance(new BigDecimal(22.00), userName);
		System.out.println(userName);
		System.out.println(jsonRequest);
		Employee employee = new Employee();
		employee.setName("John");
		employee.setAge(25);
		employee.setDeparment("HR");
		employee.setWage(15000.00);
		return employee;
	}
	
	@GET
	@Path("/users/")
	@Produces("application/json")
	public List<Player> getPlayers() {
		List<Player> players = playerEntitiesManager.listPlayers();
		for(Player p : players) {
			System.out.println(p);
		}
		return players;
	}


}
