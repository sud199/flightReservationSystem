package com.Sudhanshu.FlightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sudhanshu.FlightReservation.entites.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
