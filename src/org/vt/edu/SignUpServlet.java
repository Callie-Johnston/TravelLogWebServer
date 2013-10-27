package org.vt.edu;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		//Get parameters
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//Go to storage
		Boolean signedUp = LogStorage.signUpUser(username, password);
		
		//Send response
		resp.setContentType("text/xml; charset=UTF-8");
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.getWriter().write("<?xml version=1.0 encoding=UTF-8?>");
		resp.getWriter().write("<signup>");
		
		if (signedUp) {
			resp.getWriter().write("<result>true</result>");
		}
		else {
			resp.getWriter().write("<result>false</result>");
		}
		
		resp.getWriter().write("</signup>");
	}
	
}
