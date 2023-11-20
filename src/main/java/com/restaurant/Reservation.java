package com.restaurant;

import java.io.Serializable;

public class Reservation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String surname, date, startTime;
	
	public Reservation(String surname, String date, String startTime) {
		this.surname = surname;
		this.date = date;
		this.startTime = startTime;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	

}
