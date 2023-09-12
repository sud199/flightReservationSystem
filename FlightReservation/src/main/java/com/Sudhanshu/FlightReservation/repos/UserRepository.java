package com.Sudhanshu.FlightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sudhanshu.FlightReservation.entites.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
