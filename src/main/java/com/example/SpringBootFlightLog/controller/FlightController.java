package com.example.SpringBootFlightLog.controller;

import com.example.SpringBootFlightLog.entity.Flight;
import com.example.SpringBootFlightLog.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/flights")
@AllArgsConstructor
@SuppressWarnings("unused")
public class FlightController {

    @Autowired
    private final FlightService flightService;

    @GetMapping(value = "")
    public String showFlights(Model model){
        model.addAttribute("flights", flightService.findAllFlights());
        model.addAttribute("title", "Flight List");
        return "allHTML/index";
    }

    @GetMapping(value = "/{id}")
    public String deleteFlight(@PathVariable Long id){
        flightService.deleteExistingFlight(id);
        return "redirect:";
    }

    @GetMapping(value = "/new")
    public String newFlightForm(Model model){
        model.addAttribute("title", "Add new Flight");
        return "allHTML/new";
    }

    @PostMapping(value = "/new")
    public String createFlightForm(@ModelAttribute Flight flight){
        flightService.logNewFlight(flight);
        return "redirect:";
    }
}
