package com.example.campusrideshare.domains;

public enum Status {
    AVAILABLE,
    UNAVAILABLE,
    COMPLETED,
    CANCELLED;

    @Override
    public String toString(){
        return switch (this.ordinal()){
            case 0 -> "Available";
            case 1 -> "Unavailable";
            case 2 -> "Completed";
            case 3 -> "Cancelled";
            default -> "N/A";
        };
    }
}
