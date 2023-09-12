package com.Sudhanshu.FlightReservation.services;

import com.Sudhanshu.FlightReservation.dataTransferObject.ReservationRequest;
import com.Sudhanshu.FlightReservation.entites.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);
}
