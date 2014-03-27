/*
 * Any use, copying, modification, distribution and selling of this software
 * and its documentation for any purposes without SoftwareMind's written permission
 * is hereby prohibited
 *
 */
package ee.playtech.trial.server.ws.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA. User: Mateusz Date: 15.04.13 Time: 20:27
 */
@Path("/")
@Service
public class CommentWebservice {

	/**
	 * example: http://localhost:9998/comment/?poiId=1
	 * 
	 * @param poiId
	 *            id of Place for which comments should be obtained
	 * @return returns all comments for Place with id equal to poiId
	 */
	@POST
	@Path("/{userName}/balance/")
	@Consumes("application/json")
	@Produces("application/json")
	public Employee getEmployee(@PathParam("userName") String userName, String jsonRequest) {
		System.out.println(userName);
		System.out.println(jsonRequest);
		Employee employee = new Employee();
		employee.setName("John");
		employee.setAge(25);
		employee.setDeparment("HR");
		employee.setWage(15000.00);
		return employee;
	}

}
