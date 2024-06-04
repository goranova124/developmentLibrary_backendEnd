package org.example.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UptimeData {
    private List<TellTaleInfo> tellTaleInfo;
    private Integer serviceDistance;
    private double engineCoolantTemperature;
    private Integer serviceBrakeAirPressureCircuit1;
    private Integer serviceBrakeAirPressureCircuit2;
    private Integer durationAtLeastOneDoorOpen;
    private AlternatorInfo alternatorInfo;
    private Integer bellowPressureFrontAxleLeft;
    private Integer bellowPressureFrontAxleRight;
    private Integer bellowPressureRearAxleLeft;
    private Integer bellowPressureRearAxleRight;

}
