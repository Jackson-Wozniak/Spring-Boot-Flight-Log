package com.example.SpringBootFlightLog.service;

import com.example.SpringBootFlightLog.entity.Flight;
import com.example.SpringBootFlightLog.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    final private FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    public List<Flight> getFlights(){
        return flightRepository.findAll();
    }

    public void addFlight(Flight flight){
        flightRepository.save(flight);
    }
}
