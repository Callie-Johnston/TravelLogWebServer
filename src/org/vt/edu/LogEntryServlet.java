package org.vt.edu;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogEntryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		//Get input and go to storage
		String username = req.getParameter("username");
		
		String result = LogStorage.retrieveUserEntries(username);
		
		//Sennd response back
		resp.setContentType("text/xml; charset=UTF-8");
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.getWriter().write(result);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		//Get input
		String username = req.getHeader("username");
		String location = req.getParameter("location");
		String date = req.getParameter("date");
		String notes = req.getParameter("notes");
		String rating = req.getParameter("rating");	
		
		String[] photos = new String[5];
		photos[0] = req.getParameter("photo0");
		photos[1] = req.getParameter("photo1");
		photos[2] = req.getParameter("photo2");
		photos[3] = req.getParameter("photo3");
		photos[4] = req.getParameter("photo4");
		
		for (int i = 0; i < 5; i++) {
			if (photos[i] == null) {
				photos[i] = "";
			}
		}
		
		//Go to storage
		Boolean result = LogStorage.addUserEntry(username, location, date, notes, rating, photos);
		
		//Send result back
		if (result) {
			resp.setContentType("text/xml; charset=UTF-8");
			resp.setStatus(HttpServletResponse.SC_OK);
		}
		else {
			resp.setContentType("text/xml; charset=UTF-8");
			resp.setStatus(HttpServletResponse.SC_CONFLICT);
		}
	}
	
}
