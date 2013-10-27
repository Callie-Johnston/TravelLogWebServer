package org.vt.edu;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// Get input
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//Go to storage
		String reason = LogStorage.logInUser(username, password);
		
		//Send result back
		resp.setContentType("text/xml; charset=UTF-8");
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.getWriter().write("<?xml version=1.0 encoding=UTF-8?>");
		
		String success = null;
		
		if (reason == "Login") {
			success = "Success";
		}
		else if (reason == "Incorrect Password") {
			success = "Failure";
		}
		else if (reason == "No known username") {
			success = "Failure";
		}
		
		resp.getWriter().write("<login>");
		resp.getWriter().write("<result>" + success + "</result>");
		resp.getWriter().write("<username>" + username + "</username>");
		resp.getWriter().write("<reason>" + reason + "</reason>");
		resp.getWriter().write("</login>");
	}
	
}
