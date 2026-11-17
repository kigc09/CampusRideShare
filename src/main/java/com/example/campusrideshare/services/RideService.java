package com.example.campusrideshare.services;

import com.example.campusrideshare.data.RideRepository;
import com.example.campusrideshare.domains.Campus;
import com.example.campusrideshare.domains.Ride;
import com.example.campusrideshare.domains.Status;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class RideService {
    private static final Logger logger = LoggerFactory.getLogger(RideService.class);
    private final RideRepository rideRepo;

    public RideService(RideRepository rr){ rideRepo = rr;}

    @Transactional
    public Ride registerNewRide(Ride ride){
        /**if(ride.hasImage()){
            String imageName = ride.getImage().getImageName();
            imageName = ride.getName() + imageName.substring(imageName.lastIndexOf("."));
            ride.getImage().setImageName(imageName);
        }**/

        ride = rideRepo.save(ride);

        return ride;
    }

    public Optional<Ride> getRideById(UUID id){ return rideRepo.findById(id); }

    public Map<UUID, Ride> getAllRides(){
        Map<UUID, Ride> db = new HashMap<>();
        rideRepo.findAll().forEach(ride -> db.put(ride.getId(), ride));
        return db;
    }

    public Map<UUID, Ride> searchRides(Campus campus, Status status){
        Map<UUID, Ride> db = new HashMap<>();

        boolean hasName = campus != null;
        boolean hasType = status != null;

        if (hasName && hasType){

            return getAllRides();
        }
        return db;
    }

    @Transactional
    public boolean updateRide(UUID id, Ride ride){
        if(!rideRepo.existsById(id)){
            logger.info("Error in saving ride, ID: {} doesn't exist.", id);
            return false;
        }
        Ride lookup = rideRepo.findById(id).get();


        ride.setId(id);
        rideRepo.save(ride);

        return true;
    }

    @Transactional
    public boolean deleteRideById(UUID id){
        if(!rideRepo.existsById(id)){
            logger.info("Error, no ride with ID: {}", id);
            return false;
        }
        rideRepo.deleteById(id);
        logger.info("Ride deleted with ID: {}", id);
        return true;
    }
}
