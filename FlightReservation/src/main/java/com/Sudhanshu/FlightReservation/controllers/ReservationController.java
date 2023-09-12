package com.Sudhanshu.FlightReservation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Sudhanshu.FlightReservation.repos.FlightRepository;
import com.Sudhanshu.FlightReservation.services.ReservationService;
import com.Sudhanshu.FlightReservation.dataTransferObject.ReservationRequest;
import com.Sudhanshu.FlightReservation.entites.Flight;
import com.Sudhanshu.FlightReservation.entites.Reservation;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId")Long flightId , ModelMap modelMap) {
		Flight flight = flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight",flight);
		return "completeReservation";
	}
	
	@RequestMapping(value="/completeReservation" , method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg" ,"Reservation created successfully with reservation id is "+reservation.getId());
		return "reservationConfirmation";
	}

} 
