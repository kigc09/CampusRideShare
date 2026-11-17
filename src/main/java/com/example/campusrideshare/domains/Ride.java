package com.example.campusrideshare.domains;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String departureAddress;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime departureTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Campus campus;
    @Column(nullable = false)
    private int seatsAvailable;
    @Column(nullable = false)
    private String status;

    public Ride(){}

    public Ride(UUID id, String name, String departureAddress, LocalDateTime departureTime, Campus campus, int seatsAvailable, String status){
        this.id = id;
        this.name = name;
        this.departureAddress = departureAddress;
        this.departureTime = departureTime;
        this.campus = campus;
        this.seatsAvailable = seatsAvailable;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDepartureAddress() {
        return departureAddress;
    }

    public void setDepartureAddress(String departureAddress) {
        this.departureAddress = departureAddress;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "RIDE {" +
                "id=" + id +
                " name='" + name + "\'" +
                " departureAddress= " + departureAddress +
                " departureTime= " + departureTime +
                " campus= " + campus +
                " seatsAvailable= " + seatsAvailable +
                " status= " + status +
                "}";
    }
}
