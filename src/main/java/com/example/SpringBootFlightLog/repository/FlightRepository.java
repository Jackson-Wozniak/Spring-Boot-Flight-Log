package com.example.SpringBootFlightLog.repository;

import com.example.SpringBootFlightLog.entity.Flight;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
