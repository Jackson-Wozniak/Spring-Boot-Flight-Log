package com.example.SpringBootFlightLog.service;

import com.example.SpringBootFlightLog.exception.FlightNotFoundException;
import com.example.SpringBootFlightLog.entity.Flight;
import com.example.SpringBootFlightLog.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FlightService {

    @Autowired
    final private FlightRepository flightRepository;

    public List<Flight> findAllFlights(){
        return flightRepository.findAll();
    }

    public void logNewFlight(Flight flight){
        flightRepository.save(flight);
    }

    public void deleteExistingFlight(Long id){
        flightRepository.delete(flightRepository.findById(id).orElseThrow(
                () -> new FlightNotFoundException("Cannot Find Existing Flight To Delete!")));
    }
}
