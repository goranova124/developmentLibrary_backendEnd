package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleStatus {
    private String vin;
    private TriggerType triggerType;
    private String createdDateTime;
    private String receivedDateTime;
    private Integer hrTotalVehicleDistance;
    private double totalEnginHours;
    private DriveridObject driver1Id;
    private Integer grossCombinationVehicleWeight;
    private Integer engineTotalFuelUsed;
    private Integer totalFuelUsedGaseous;
    private String status2OfDoors;
    private DoorStatus doorStatus;
    private SnapShotData snapshotData;
    private AccumulatedData accumulatedData;
    private UptimeData uptimeData;

}
