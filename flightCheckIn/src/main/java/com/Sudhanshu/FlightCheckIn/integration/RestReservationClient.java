package com.Sudhanshu.FlightCheckIn.integration;

import com.Sudhanshu.FlightCheckIn.integration.dataTransferobject.Reservation;
import com.Sudhanshu.FlightCheckIn.integration.dataTransferobject.ReservationUpdateRequest;

public interface RestReservationClient {
	
	public Reservation findReservation(Long id);

	public Reservation updateReservation(ReservationUpdateRequest request);
}
