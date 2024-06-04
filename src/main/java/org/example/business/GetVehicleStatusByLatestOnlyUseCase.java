package org.example.business;

import org.springframework.http.ResponseEntity;

public interface GetVehicleStatusByLatestOnlyUseCase {
    ResponseEntity<String> getVehiclesStatusesByLatestOnly(String authorization, String triggerFilter
            , String dataType, String vin, String accept, String contentFilter);

}
