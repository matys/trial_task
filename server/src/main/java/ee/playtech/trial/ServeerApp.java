package ee.playtech.trial;

import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.jersey.spi.container.servlet.ServletContainer;

import ee.playtech.trial.server.ws.rest.UserBalanceWebservice;

/**
 * Hello world!
 * 
 */
public class ServeerApp {
	public static void main(String[] args) throws Exception {
		System.out.println("Maven + Hibernate + HSQL");
		// Session session = HibernateUtil.getSessionFactory().openSession();
		// session.beginTransaction();
		// ServeerApp app = new ServeerApp();
		// app.saveContact("Riya");
		// app.listContact();

		// spring initialize classes
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		// System.out
		// .println("Select mode of backend: \n0 - run database from scratch (drop-create database) \n1 - "
		// + "continue "
		// +
		// "running of backend (update database)\n2 - only webservice, no crawling\n");
		// Scanner in = new Scanner(System.in);
		// Integer mode = new Integer(in.nextLine().trim());
		// if (mode == 0) {
		// HibernateUtil.setMode("create");
		// } else if (mode == 1 || mode == 2) {
		// HibernateUtil.setMode("update");
		// } else {
		// System.exit(1);
		// }

		// start gathering data
		BeanFactory factory = context;
		if(factory.getBean("playerEntitiesManager") == null){
			System.out.println("NPE!!!!!!!!!!");
		}
		// if (mode == 0) {
		// DataInitializer dataInitializer = (DataInitializer) factory
		// .getBean("dataInitializer");
		// dataInitializer.initData();
		// }

		// if (mode != 2) {
		// if (mode == 1) {
		// crawler.reloadTasks();
		// }
		// crawlerThread.start();
		//
		// Runtime.getRuntime().addShutdownHook(new Thread() {
		// @Override
		// public void run() {
		// crawler.saveState();
		// }
		// });
		// }

		// HttpServer server = null;
		// try {
		// server = HttpServerFactory.create("http://localhost:8888/");
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// server.start();

		// AbstractResource resource = IntrospectionModeller
		// .createResource(CommentWebservice.class);
		// System.out.println("Path is " + resource.getUriPath().getValue());
		//
		// String uriPrefix = resource.getUriPath().getValue();
		// for (AbstractSubResourceMethod srm :
		// resource.getSubResourceMethods()) {
		// String uri = uriPrefix + "/" + srm.getUriPath().getValue();
		// System.out.println(srm.getHttpMethod() + " at the path " + uri
		// + " return " + srm.getMethod().getName());
		// }
		ServletHolder sh = new ServletHolder(ServletContainer.class);
		sh.setInitParameter(
				"com.sun.jersey.config.property.resourceConfigClass",
				"com.sun.jersey.api.core.PackagesResourceConfig");
		sh.setInitParameter("com.sun.jersey.config.property.packages", "ee.playtech.trial.server.ws.rest");
		sh.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature",
				"true");

		Server server = new Server(9999);
		ServletContextHandler servletContext = new ServletContextHandler(
				server, "/", ServletContextHandler.SESSIONS);
		servletContext.addServlet(sh, "/*");
		server.start();
		System.out.println("Server running");
		System.out.println("Hit return to stop...");
		server.join();
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Stopping server");
		server.stop();
		System.out.println("Server stopped");

		// run tests
		// RequestSaveTest.run();
		// PlaceSaveTest.run();
		// HibernateUtil.getSessionFactory().close();
		System.exit(0);

	}

}