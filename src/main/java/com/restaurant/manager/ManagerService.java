package com.restaurant.manager;

import javax.ws.rs.*;
import com.restaurant.Restaurant;

@Path("/")
public class ManagerService {
	
	private static Restaurant restaurant = new Restaurant();
	
	@GET @Path("/restaurant/reservations") @Produces("application/json")
	public String getReservations() {
		String pattern = "{ \"Reservations\":\"%s\",  \"Booked tables\":\"%s\"}";
		return String.format(pattern, Restaurant.getBookedTables(), restaurant.toString());
	}
	
}
