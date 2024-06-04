package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetVehicleResponse {
    private VehicleResponseWrapper vehicleResponse;
    private boolean moreDataAvailable;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VehicleResponseWrapper {
        private List<Vehicle> vehicles;
    }
}
