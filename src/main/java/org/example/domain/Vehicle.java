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
public class Vehicle {


    private String vin;
    private String customerVehicleName;
    private String brand;
    private ProductionDate productionDate;
    private String type;
    private String model;
    private List<String> possibleFuelType;
    private String emissionLevel;
    private String chassisType;
    private int noOfAxles;
    private List<String> authorizedPaths;

}
