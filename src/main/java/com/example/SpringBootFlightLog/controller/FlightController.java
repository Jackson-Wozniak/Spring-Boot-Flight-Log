package com.example.SpringBootFlightLog.controller;

import com.example.SpringBootFlightLog.entity.Flight;
import com.example.SpringBootFlightLog.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/log")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService){
        super();
        this.flightService = flightService;
    }

    @RequestMapping(value = "")
    public String showFlights(Model model){
        model.addAttribute("flights", flightService.getFlights());
        model.addAttribute("title", "Flight List");
        return "allHTML/index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newFlightForm(Model model){
        model.addAttribute("title", "Add new Flight");
        return "allHTML/new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createFlightForm(@ModelAttribute Flight flight){
        flightService.addFlight(flight);
        return "redirect:";
    }
}
