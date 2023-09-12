package com.Sudhanshu.FlightReservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sudhanshu.FlightReservation.entites.Flight;
import com.Sudhanshu.FlightReservation.entites.Passenger;

import com.Sudhanshu.FlightReservation.dataTransferObject.ReservationRequest;
import com.Sudhanshu.FlightReservation.entites.Reservation;
import com.Sudhanshu.FlightReservation.repos.FlightRepository;
import com.Sudhanshu.FlightReservation.repos.PassengerRepository;
import com.Sudhanshu.FlightReservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		
		Long flightId=request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation  reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		
		return savedReservation ;
	}

}
