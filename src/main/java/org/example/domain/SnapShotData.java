package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SnapShotData {
    private GnssPosition gnssPosition;
    private double wheelBasedSpeed;
    private double tachographSpeed;
    private double engineSpeed;
    private String fuelType;
    private double fuelLevel1;
    private double fuelLevel2;
    private double catalystFuelLevel;
    private String driver1WorkingState;
    private DriveridObject driver2Id;
    private String driver2WorkingState;
    private double ambientAirTemperature;
    private boolean parkingBrakeSwitch;
    private double hybridBatteryPackRemainingCharge;

    }
