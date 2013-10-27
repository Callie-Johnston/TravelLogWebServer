package org.vt.edu;

import java.util.Vector;

//Class used to keep track of users and their entries
public class TravelUser {
	
	String username_;
	String password_;
	Vector<String> locations_;
	Vector<String> dates_;
	Vector<String> notes_;
	Vector<String> ratings_;
	Vector<String[]> photos_;
	
	public TravelUser(String newUsername, String newPassword) {
		username_ = newUsername;
		password_ = newPassword;
		locations_ = new Vector<String>(1,1);
		dates_ = new Vector<String>(1,1);
		notes_ = new Vector<String>(1,1);
		ratings_ = new Vector<String>(1,1);
		photos_ = new Vector<String[]>(1,1);
	}
}
