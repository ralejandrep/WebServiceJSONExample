package net.alejandre.webserviceexample.entities;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Account implements Serializable {

	private String website;
	private User user;
	private ArrayList<String> info;
	
	public Account() {}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<String> getInfo() {
		return info;
	}

	public void setInfo(ArrayList<String> info) {
		this.info = info;
	}

}
