package com.example.campusrideshare.data;

import com.example.campusrideshare.domains.Campus;
import com.example.campusrideshare.domains.Ride;
import com.example.campusrideshare.domains.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface RideRepository extends JpaRepository<Ride, UUID> {

}
