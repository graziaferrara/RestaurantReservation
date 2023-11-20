package com.restaurant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.UUID;

public class Restaurant implements Serializable{

	private static final long serialVersionUID = 1L;
	private static int bookedTables = 0;
	private final static int MAXBOOKEDTABLES = 10;
	
	private static HashMap <UUID, Reservation> reservations = new HashMap <> ();
	
	public static int getBookedTables() {
		return bookedTables;
	}
	
	public static HashMap<UUID, Reservation> getReservations() {
		return reservations;
	}
	
	public UUID book(String surname, String date, String startTime) throws Exception {
		if (bookedTables < MAXBOOKEDTABLES) {
			UUID id = UUID.randomUUID();
			reservations.put(id, new Reservation(surname, date, startTime));
			bookedTables++;
			return id;
		} else throw new Exception("No more available tables");
	}

	public boolean cancel (String id) {
		if (bookedTables > 0 && reservations.containsKey(UUID.fromString(id))) {
			reservations.remove(UUID.fromString(id));
			bookedTables--;
			return true;
		} else return false;
	}

	@Override
	public String toString() {
		String jsonFormat = "[\n";
		String pattern = "{ \"ID\":\"%s\", \"Surname\":\"%s\", \"Date\":\"%s\", \"Start time\":\"%s\"}";
		for (Entry<UUID,Reservation> r : reservations.entrySet()) {
			jsonFormat += "\t" + String.format(pattern, r.getKey(), r.getValue().getSurname(), r.getValue().getDate(), r.getValue().getStartTime()) + ",\n";
		}
		jsonFormat += "\n\t\t]\n";
		return jsonFormat;
	}
	
	

}
