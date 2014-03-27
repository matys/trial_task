package ee.playtech.trial.server.ws.rest.monitoring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class AuthFilter extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView("HelloWorldPage");
		System.out
				.println("TEEEEEEEEEEEEEEEEEEEEEEESJOHJIHJBJKSHBDHIGIYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY!!!!!!!!!!!!!!");
		throw new NotImplementedException();

	}
}