package com.Sudhanshu.FlightReservation.controllers;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Sudhanshu.FlightReservation.entites.Flight;
import com.Sudhanshu.FlightReservation.repos.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from")String from ,@RequestParam("to") String to ,@RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date departureDate,ModelMap modelMap) {
		
		List<Flight> flights=flightRepository.findFlights(from , to , departureDate);
		modelMap.addAttribute("flights",flights);
		return "displayFlights";
		
	}

}
