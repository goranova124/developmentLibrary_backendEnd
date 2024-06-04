package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehiclePosition {
    private String vin;
    private TriggerType triggerType;
    private String createdDateTime;
    private String receivedDateTime;
    private GnssPosition gnssPosition;
    private double wheelBasedSpeed;
    private double tachographSpeed;

}
