package org.vt.edu;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class MainServlet extends HttpServlet {
	
	public static void main(String[] args) throws Exception{
		
		WebAppContext context = new WebAppContext();
		context.setWar("war");
		context.setContextPath("/");

		Server server = new Server(8090);
		server.setHandler(context);
		
		server.start();
		server.join();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.getWriter().write("Welcome to the Travel Log\n");
		resp.getWriter().write("Please go to a username");
	}

}
