package com.example.campusrideshare.domains;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@Scope("singleton")
public class RideDB {
    private Map<UUID, Ride> rides = new HashMap<>();

    public Map<UUID, Ride> getRides() { return rides; }

    public void addRide(Ride ride) { rides.put(ride.getId(), ride);}
}
