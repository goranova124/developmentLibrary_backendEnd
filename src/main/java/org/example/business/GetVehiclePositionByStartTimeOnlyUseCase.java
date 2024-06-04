package org.example.business;

import org.example.domain.GetVehiclePositionResponse;
import org.springframework.http.ResponseEntity;

public interface GetVehiclePositionByStartTimeOnlyUseCase {
    ResponseEntity<GetVehiclePositionResponse> getVehiclesPositionByStartTime(String authorization,
                                                                              String triggerFilter
            , String dataType, String vin, String accept, String startTime, String stopTime,String lastVin);
}
