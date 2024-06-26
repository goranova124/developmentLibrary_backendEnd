package org.example.business.impl;

import org.example.business.GetVehicleStatusByLatestOnlyUseCase;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

@Service

public class GetVehicleStatusByLatestOnlyUseCseImpl implements GetVehicleStatusByLatestOnlyUseCase {


    @Override
    public ResponseEntity<String> getVehiclesStatusesByLatestOnly(String authorization, String triggerFilter, String dataType, String vin, String accept, String contentFilter) {
        try {

            WebClient webClient = WebClient.create();
            HttpHeaders headers = new HttpHeaders();

            headers.add("Authorization", authorization);
            headers.add("Accept", accept);
            StringBuilder stringBuilder = new StringBuilder("https://api.connect.daf.com/rfms/vehiclestatuses?latestOnly=true");
            if (triggerFilter != null && !triggerFilter.trim().isEmpty()) {
                stringBuilder.append("&triggerFilter=").append(triggerFilter);
            }
            if (dataType != null && !dataType.isEmpty()) {
                stringBuilder.append("&dataType=").append(dataType);
            }
            if (vin != null && !vin.isEmpty()) {
                stringBuilder.append("&vin=").append(vin);
            }
            if (contentFilter != null && !contentFilter.isEmpty()) {
                stringBuilder.append("&contentFilter=").append(contentFilter);
            }

            ClientResponse clientResponse = webClient.get()
                    .uri(stringBuilder.toString())
                    .headers(h -> h.addAll(headers))
                    .exchange()
                    .block();
            if (clientResponse != null) {
                HttpStatus statusCode = clientResponse.statusCode();
                if (statusCode.isError()) {
                    return ResponseEntity.status(statusCode).body(null);
                } else {
                    String body = clientResponse.bodyToMono(String.class).block();
                    return ResponseEntity.status(statusCode).body(body);
                }
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } catch (Exception e) {
            String errorMessage = "An error occurred in getVehiclesPositionByLatestOnly: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }


}
