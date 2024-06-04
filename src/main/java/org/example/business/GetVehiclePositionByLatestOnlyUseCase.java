package org.example.business;

import org.springframework.http.ResponseEntity;

public interface GetVehiclePositionByLatestOnlyUseCase {
    ResponseEntity<String> getVehiclesPositionByLatestOnly(String authorization, String triggerFilter
            , String dataType, String vin, String accept);
}
