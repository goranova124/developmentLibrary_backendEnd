package org.example.business;

import org.example.domain.GetVehicleResponse;
import org.springframework.http.ResponseEntity;

public interface GetVehiclesUseCase {
    ResponseEntity<GetVehicleResponse> getVehicles(String authorization, String accept, String contentType);
}
