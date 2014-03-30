package ee.playtech.trial.server.ws.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import ee.playtech.trial.server.database.PlayerEntitiesManager;
import ee.playtech.trial.server.model.BalanceChangeInfo;
import ee.playtech.trial.server.model.entity.Player;
import ee.playtech.trial.server.ws.rest.request.AddBalanceChangeRequest;
import ee.playtech.trial.server.ws.rest.request.validator.AddBalanceChangeRequestValidator;
import ee.playtech.trial.server.ws.rest.response.AddBalanceChangeResponse;

@Path("/")
@Api(value = "/", description = "Operations on user balance")
@Component
public class UserWalletResource {

	private static final Logger LOGGER = Logger
			.getLogger(UserWalletResource.class);
	private static final int HIBERNATE_ERROR_STATUS_CODE = 421;
	@Autowired
	private AddBalanceChangeRequestValidator addBalanceChangeRequestValidator;
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
	 * @returns data about balance change and current balance of user
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/{userName}/wallet/balanceChange/")
	@ApiOperation(value = "add balance to user", notes = "More notes about this method", response = AddBalanceChangeResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 430, message = "Database error"),
			@ApiResponse(code = AddBalanceChangeRequestValidator.NO_USER_NAME_ERROR_CODE, message = AddBalanceChangeRequestValidator.NO_USER_NAME_ERROR_DESCRIPTION),
			@ApiResponse(code = AddBalanceChangeRequestValidator.NO_AMOUNT_ERROR_CODE, message = AddBalanceChangeRequestValidator.NO_AMOUNT_ERROR_DESCRIPTION),
			@ApiResponse(code = AddBalanceChangeRequestValidator.NO_TRANSACTION_ID_ERROR_CODE, message = AddBalanceChangeRequestValidator.NO_TRANSACTION_ID_ERROR_DESCRIPTION) })
	public Response addBalanceChange(@PathParam("userName") String userName,
			AddBalanceChangeRequest request,
			@Context final HttpServletResponse response) {
		int errorCode = validate(userName, request, response);
		BalanceChangeInfo balanceChangeInfo = null;
		if (errorCode == AddBalanceChangeRequestValidator.OK_STATUS_CODE) {
			try {
				balanceChangeInfo = playerEntitiesManager.changeUserBalance(
						request.getAmount(), userName);
			} catch (HibernateException e) {
				response.setStatus(HIBERNATE_ERROR_STATUS_CODE);
			} // another exceptions will be mapped with 500 by default
		}
		return Response.status(errorCode)
				.entity(createResponse(request, balanceChangeInfo))
				.type(MediaType.APPLICATION_JSON).build();
	}

	private int validate(String userName, AddBalanceChangeRequest request,
			final HttpServletResponse response) {
		int errorCode = addBalanceChangeRequestValidator.validate(request,
				userName);
		if (errorCode != 0) {
			response.setStatus(errorCode);
		}
		return errorCode;
	}

	/**
	 * example:
	 * 
	 * GET /users/ HTTP/1.1 Host: localhost:9999 Cache-Control: no-cache
	 * 
	 * @return list of all players with their current wallet
	 */
	@GET
	@Path("/users/")
	@Produces("application/json")
	public List<Player> getPlayers() {
		return playerEntitiesManager.listPlayers();
	}

	private AddBalanceChangeResponse createResponse(
			AddBalanceChangeRequest request, BalanceChangeInfo balanceChangeInfo) {
		AddBalanceChangeResponse response = new AddBalanceChangeResponse();
		if (balanceChangeInfo != null) {
			response.setBalanceAfterChange(balanceChangeInfo
					.getCurrentBalance());
			response.setBalanceVersion(balanceChangeInfo.getVersion());
			response.setTransactionId(request.getTransactionId());
			response.setBalanceChange(balanceChangeInfo.getBalanceChange());
		}
		return response;
	}

}
