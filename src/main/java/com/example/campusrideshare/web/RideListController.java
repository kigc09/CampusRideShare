package com.example.campusrideshare.web;

import com.example.campusrideshare.domains.Campus;
import com.example.campusrideshare.domains.Ride;
import com.example.campusrideshare.domains.Status;
import com.example.campusrideshare.services.RideService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/list")
public class RideListController {
    private static final Logger logger = LoggerFactory.getLogger(RideListController.class);
    private final RideService rideService;

    public RideListController(RideService rs){rideService = rs;}

    @ModelAttribute
    public void addRideStatusToModel(Model model){ model.addAttribute("Status", Status.values()); }

    @ModelAttribute("pageTitle")
    public String addPageTitle(){return "List Rides";}

    @GetMapping
    public String listRides(@RequestParam(defaultValue = "") Campus campus,
                            @RequestParam(required = false) Status status,
                            Model model){
        Map<UUID, Ride> rideDB = rideService.getAllRides();
        model.addAttribute("rideDB", rideDB);
        model.addAttribute("campus", campus);
        model.addAttribute("status", status);

        return "listRides";
    }
}
