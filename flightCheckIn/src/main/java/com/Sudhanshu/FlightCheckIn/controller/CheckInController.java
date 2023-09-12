package com.Sudhanshu.FlightCheckIn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Sudhanshu.FlightCheckIn.integration.RestReservationClient;
import com.Sudhanshu.FlightCheckIn.integration.dataTransferobject.Reservation;
import com.Sudhanshu.FlightCheckIn.integration.dataTransferobject.ReservationUpdateRequest;

@RestController
public class CheckInController {
	
	@Autowired
	RestReservationClient restClient;
	
	@RequestMapping("/showStartCheckIn")
	public String showStartCheckIn() {
		return "startCheckIn";
	}
	
	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") Long reservationId , ModelMap modelMap) {
		Reservation reservation = restClient.findReservation(reservationId);
		modelMap.addAttribute("reservation",reservation);
		return "displayReservationDetails";
	}
	
	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId") Long reservationId,
			@RequestParam("numberOfBags") int numberOfBags) {
		ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
		reservationUpdateRequest.setId(reservationId);
		reservationUpdateRequest.setCheckedIn(true);
		reservationUpdateRequest.setNumberOfBags(numberOfBags);
		restClient.updateReservation(reservationUpdateRequest);
		return "checkInConfirmation";

	}

}
