/*
 * Any use, copying, modification, distribution and selling of this software
 * and its documentation for any purposes without SoftwareMind's written permission
 * is hereby prohibited
 *
 */
package ee.playtech.trial.server.ws.rest;

import java.util.List;

import com.wordnik.swagger.annotations.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ee.playtech.trial.server.database.PlayerEntitiesManager;
import ee.playtech.trial.server.model.BalanceChangeInfo;
import ee.playtech.trial.server.model.entity.Player;
import ee.playtech.trial.server.ws.rest.request.AddBalanceChangeRequest;
import ee.playtech.trial.server.ws.rest.response.AddBalanceChangeResponse;

@Path("/")
@Api(value = "/", description = "Operations on user balance")
@Component
public class UserWalletResource {

	private static final Logger LOGGER = Logger.getLogger(UserWalletResource.class);
	@Autowired
	private PlayerEntitiesManager playerEntitiesManager;

	
	/**
	 * Adds balance change to current balance for given user in uri.
	 * 
	 * example:
	 * 
	 * POST /TestUser2/wallet/balanceChange/ HTTP/1.1 Host: localhost:9999
	 * Content-Type: application/json Cache-Control: no-cache
	 * 
	 * {"transactionId" : 22, "amount" :12.00}
	 * 
	 * (another solution could be to create PUT method. However, for PUT method
	 * more accurate would be /{userName}/balance/ parameterized with new
	 * balance amount value)
	 * 
	 * @reurns data about balance change and current balance of user
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/{userName}/wallet/balanceChange/")
	@ApiOperation(value = "add balance to user", notes = "More notes about this method", response = AddBalanceChangeResponse.class)
	@ApiResponses(value = {
	  @ApiResponse(code = 400, message = "TODO"),
	  @ApiResponse(code = 404, message = "TODO") 
	})
	public AddBalanceChangeResponse addBalanceChange(
			@PathParam("userName") String userName,
			AddBalanceChangeRequest request) {
		BalanceChangeInfo balanceChangeInfo = playerEntitiesManager
				.changeUserBalance(request.getAmount(), userName);
		return createResponse(request, balanceChangeInfo);
	}

	/**
	 * example:
	 * 
	 * GET /users/ HTTP/1.1 
	 * Host: localhost:9999 
	 * Cache-Control: no-cache
	 * 
	 * @return list of all players with their current wallet
	 */
	@GET
	@Path("/users/")
	@Produces("application/json")
	public List<Player> getPlayers() {
		List<Player> players = playerEntitiesManager.listPlayers();
		for (Player p : players) {
			System.out.println(p);
		}
		return players;
	}

	private AddBalanceChangeResponse createResponse(
			AddBalanceChangeRequest request, BalanceChangeInfo balanceChangeInfo) {
		AddBalanceChangeResponse response = new AddBalanceChangeResponse();
		response.setBalanceAfterChange(balanceChangeInfo.getCurrentBalance());
		response.setBalanceVersion(balanceChangeInfo.getVersion());
		response.setTransactionId(request.getTransactionId());
		response.setBalanceChange(balanceChangeInfo.getBalanceChange());
		return response;
	}

}
