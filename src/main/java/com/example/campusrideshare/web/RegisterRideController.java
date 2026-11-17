package com.example.campusrideshare.web;

import com.example.campusrideshare.domains.Campus;
import com.example.campusrideshare.domains.Ride;
import com.example.campusrideshare.domains.RideDB;
import com.example.campusrideshare.domains.Status;
import com.example.campusrideshare.services.RideService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterRideController {
    private static final Logger logger = LoggerFactory.getLogger(RegisterRideController.class);
    private final RideService rideService;

    public RegisterRideController(RideService rs){ rideService = rs; }

    @ModelAttribute("pageTitle")
    public String addPageTitle() { return "Register Ride"; }

    @ModelAttribute()
    public Ride ride() { return new Ride();}

    @GetMapping
    public String registerForm(Model model) {
        model.addAttribute("ride", new Ride());
        model.addAttribute("Campus", Campus.values());
        model.addAttribute("Status", Status.values());

        return "rideRegistrationForm";
    }

    @PostMapping
    public String processRideRegister(@Valid Ride ride, Errors errors) {
        logger.debug("Ride received {}", ride);

        if (errors.hasErrors()) {
            return "rideRegistrationForm";
        }

        /** updating image file name to be the animal's name in it
        if (ride.hasImage()) {
            String imageName = ride.getImage().getName();
            imageName = ride.getName() + imageName.substring(imageName.lastIndexOf("."));
            ride.getImage().setName(imageName);
        }**/

        Ride addedRide = rideService.registerNewRide(ride);
        logger.info("Ride Registered {}", ride);
        return "redirect:/view/current/" + addedRide.getId();
    }

}
