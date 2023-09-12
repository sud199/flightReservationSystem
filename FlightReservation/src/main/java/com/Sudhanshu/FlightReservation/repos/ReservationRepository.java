package com.Sudhanshu.FlightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sudhanshu.FlightReservation.entites.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
