package ee.playtech.trial;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ee.playtech.trial.common.configuration.ConfigurationProperty;


/**
 * Hello world!
 * 
 */
public class ServeerApp {
	
	private static Logger logger = Logger.getLogger(ServeerApp.class);
	
	public static void main(String[] args) throws Exception {
		//log4j configuration
		DOMConfigurator.configure("src/main/resources/log4j-conf.xml");
		// spring initialize classes
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");

		Server server = new Server(Integer.parseInt(ConfigurationProperty.SERVER_PORT.getValue()));
		configureServer(server);
		server.start();
		System.out.println("Server running");
		System.out.println("Hit return to stop...");
		server.join();
		try {
			System.in.read();
		} catch (IOException e) {
			logger.error(e);
		}
		logger.info("Stopping server");
		server.stop();
		logger.info("Server stopped");

		System.exit(0);

	}

	private static void configureServer(Server server) {
		WebAppContext webAppContext = new WebAppContext();
		webAppContext.setDescriptor("src/webapp/WEB-INF/web.xml"); 
		webAppContext.setResourceBase(".");
		server.setHandler(webAppContext);
	}

}