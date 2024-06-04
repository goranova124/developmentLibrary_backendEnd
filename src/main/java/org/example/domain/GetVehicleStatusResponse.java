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
public class GetVehicleStatusResponse {
    private VehicleResponseWrapper vehiclePositionResponse;
    private boolean moreDataAvailable;
    private String moreDataAvailableLink;
    private String requestServerDateTime;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VehicleResponseWrapper {
        private List<VehicleStatus> vehicleStatuses;
    }
}
