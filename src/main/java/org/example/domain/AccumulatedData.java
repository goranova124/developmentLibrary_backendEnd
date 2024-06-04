package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccumulatedData {
    private Integer durationWheelbaseSpeedOverZero;
    private Integer distanceCruiseControlActive;
    private Integer durationCruiseControlActive;
    private Integer fuelConsumptionDuringCruiseActive;
    private Integer durationWheelbaseSpeedZero;
    private Integer fuelWheelbaseSpeedZero;
    private Integer fuelWheelbaseSpeedOverZero;
    private PtoActiveClass ptoActiveClass;
    private Integer brakePedalCounterSpeedOverZero;
    private Integer distanceBrakePedalActiveSpeedOverZero;
    private AccelerationPedalPositionClass accelerationPedalPositionClass;
    private BrakePedalPositionClass brakePedalPositionClass;
    private AccelerationClass accelerationClass;
    private HighAccelerationClass highAccelerationClass;
    private RetarderTorqueClass retarderTorqueClass;
    private DrivingWithoutTorqueClass drivingWithoutTorqueClass;
    private EngineToqueClass engineToqueClass;
    private EngineTorqueAtCurrentSpeed engineTorqueAtCurrentSpeed;
    private VehicleSpeed vehicleSpeed;
    private EngineSpeedClass engineSpeedClass;
    private AccelerationDuringBrake accelerationDuringBrake;
    private SelectedGearClass selectedGearClass;
    private CurrentGearClass currentGearClass;
    private Integer chairliftCounter;
    private Integer stopRequestCounter;
    private Integer chairkneelingCounterliftCounter;
    private Integer pramRequestCounter;



}
