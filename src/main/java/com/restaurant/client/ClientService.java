package com.restaurant.client;

import java.util.UUID;

import javax.ws.rs.*;
import com.restaurant.Restaurant;

@Path("/")
public class ClientService {
	
	private static Restaurant restaurant = new Restaurant();
	
	@POST @Path("/restaurant/book") @Produces("application/json")
	public String book(@QueryParam("surname") String surname, @QueryParam("date") String date, @QueryParam("startTime") String startTime) {
		String pattern = "{ \"Reservation status\":\"%s\"}", toPrint;
		try {
			UUID id = restaurant.book(surname, date, startTime);
			pattern = "{ \"Reservation status\":\"%s\", \"Reservation ID\":\"%s\"}";
			toPrint = "Booked successfully";
			return String.format(pattern, toPrint, id.toString());
		}catch (Exception e) {
			pattern = "{ \"Reservation status\":\"%s\"}";
			toPrint = "Couldn't book the table";
			return String.format(pattern, toPrint);
		}
	}
	
	@POST @Path("/restaurant/cancel") @Produces("application/json")
	public String cancel(@QueryParam("id") String id) {
		String pattern = "{ \"Reservation status\":\"%s\"}", toPrint;
		if (restaurant.cancel(id))
			toPrint = "Canceled successfully";
		else toPrint = "Couldn't cancel the reservation";
		return String.format(pattern, toPrint);
	}

}
