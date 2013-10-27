package org.vt.edu;

import java.util.Iterator;
import java.util.Vector;

public class LogStorage {
	
	public static Vector<TravelUser> storage = new Vector<TravelUser>(1,1);
	
	public static String logInUser(String inUsername, String inPassword) {
		
		System.out.println("Logging in");
		
		Iterator<TravelUser> itr = storage.iterator();
		String answer = null;
		
		//See if correct username + password
		while (itr.hasNext()) {
			TravelUser curUser = itr.next();
			if (curUser.username_.matches(inUsername)) {	
				if (curUser.password_.matches(inPassword)) {
					answer = "Login";
				}
				else {
					answer = "Incorrect Password";
				}
			}
		}
		
		if (answer == null) {
			answer = "No known username";
		}
		
		return answer;
	}
	
	public static Boolean signUpUser(String inUsername, String inPassword) {
		
		System.out.println("sign up user");
		
		Iterator<TravelUser> itr = storage.iterator();
		Boolean previousUsed = false;
		
		//See if user already exists
		while (itr.hasNext()) {
			TravelUser curUser = itr.next();
			if (curUser.username_.matches(inUsername)) {
				previousUsed = true;
				break;
			}
		}
		
		if (!previousUsed) {
			TravelUser newUser = new TravelUser(inUsername, inPassword);
			storage.add(newUser);
		}
		
		return !previousUsed;
	}
	
	public static Boolean addUserEntry(String inUsername, String inLocation, String inDate,
									String inNotes, String inRating, String[] inPhotos) {
		
		Iterator<TravelUser> itr = storage.iterator();
		
		//add new entry into the storage
		while (itr.hasNext()) {
			TravelUser curUser = itr.next();
			if (curUser.username_.matches(inUsername)) {
				curUser.locations_.add(inLocation);
				curUser.dates_.add(inDate);
				curUser.notes_.add(inNotes);
				curUser.ratings_.add(inRating);
				curUser.photos_.add(inPhotos);
				
				System.out.println("location: " + inLocation);
				for (int i = 0; i < inPhotos.length; i++) {
					System.out.println("photo: " + inPhotos[i]);
				}
				
				return true;
			}
		}
		
		return false;
	}
	
	public static String retrieveUserEntries(String inUsername) {
		String returnXml = null;
		
		returnXml = "<LogEntries>\n";
		
		Iterator<TravelUser> itr = storage.iterator();
		
		//Create xml to send back to user of all entries
		while (itr.hasNext()) {
			TravelUser curUser = itr.next();
			if (curUser.username_.matches(inUsername)) {
				returnXml += "<username>" + curUser.username_ + "</username>\n";
				for (int i = 0; i < curUser.dates_.size(); i++) {
					returnXml += "<Entry>\n";
					
					if (curUser.dates_.get(i) != "") {
						returnXml += "<Date>" + curUser.dates_.get(i) + "</Date>\n";
					}
					if (curUser.locations_.get(i) != "") {
						returnXml += "<Location>" + curUser.locations_.get(i) + "</Location>\n";
					}
					if (curUser.notes_.get(i) != "") {
						returnXml += "<Notes>" + curUser.notes_.get(i) + "</Notes>\n";
					}
					if (curUser.ratings_.get(i) != "") {
						returnXml += "<Rating>" + curUser.ratings_.get(i) + "</Rating>\n";
					}
					
					for (int j = 0; j < 5; j++) {
						if (curUser.photos_.get(i)[j] != "") {
							returnXml += "<Photo>" + curUser.photos_.get(i)[j] + "</Photo>\n";
						}
					}
					
					returnXml += "</Entry>\n";
				}
			}
		}
		
		returnXml += "</LogEntries>";
		
		return returnXml;
	}
}
