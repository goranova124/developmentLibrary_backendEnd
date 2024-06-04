package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GnssPosition {
    private double latitude;
    private double longitude;
    private Integer heading;
    private Integer altitude;
    private double speed;
    private String positionDateTime;
}
