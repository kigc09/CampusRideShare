package com.example.campusrideshare.domains;

public enum Campus {
    FORT_OMAHA,
    SOUTH_OMAHA,
    ELKHORN_VALLEY,
    APPLIED_TECHNOLOGY,
    FREMONT_AREA,
    MCC_SARPY,
    MCC_DIGITAL,
    MCC_ASHTON,
    MCC_NORTH,
    MCC_SOUTH,
    MCC_MAKERSPACE,
    MCC_OFFUTT,
    MCC_MASTERCRAFT,
    MCC_ILLUMINATES,
    MCC_FOUNDATION,
    MCC_SHIPPING_RECEIVING;

    @Override
    public String toString(){
        return switch (this.ordinal()){
            case 0 -> "Fort Omaha Campus (FOC)";
            case 1 -> "South Omaha Campus (SOC)";
            case 2 -> "Elkhorn Valley Campus (EVC)";
            case 3 -> "Applied Technology Center (ATC)";
            case 4 -> "Fremont Area Center (FRC)";
            case 5 -> "MCC Sarpy Center (SRP)";
            case 6 -> "MCC Digital Express/Reboot Central";
            case 7 -> "MCC at The Ashton";
            case 8 -> "MCC North Express (MXN)";
            case 9 -> "MCC South Express (MXS)";
            case 10 -> "MCC at Makerspace";
            case 11 -> "MCC at Offutt AFB Center";
            case 12 -> "MCC at The Mastercraft";
            case 13 -> "MCC at Yates Illuminates";
            case 14 -> "MCC Foundation";
            case 15 -> "MCC Shipping & Receiving";
            default -> "Fort Omaha Campus (FOC)";
        };
    }
}
