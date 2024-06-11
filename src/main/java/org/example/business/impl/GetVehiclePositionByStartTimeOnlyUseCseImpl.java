package org.example.business.impl;

import org.example.business.GetVehiclePositionByStartTimeOnlyUseCase;
import org.example.domain.GetVehiclePositionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

@Service

public class GetVehiclePositionByStartTimeOnlyUseCseImpl implements GetVehiclePositionByStartTimeOnlyUseCase {


    @Override
    public ResponseEntity<GetVehiclePositionResponse> getVehiclesPositionByStartTime(String authorization, String triggerFilter
            , String dataType, String vin, String accept, String startTime, String stopTime, String lastVin) {
        WebClient webClient = WebClient.create();
        HttpHeaders headers = new HttpHeaders();

        headers.add("Authorization", authorization);
        headers.add("Accept", accept);
        StringBuilder stringBuilder = new StringBuilder("https://api.connect.daf.com/rfms/vehiclepositions?");
        stringBuilder.append("starttime=").append(startTime);
        if (triggerFilter != null && !triggerFilter.trim().isEmpty()) {
            stringBuilder.append("&triggerFilter=").append(triggerFilter);
        }
        if (dataType != null && !dataType.isEmpty()) {
            stringBuilder.append("&dataType=").append(dataType);
        }
        if (vin != null && !vin.isEmpty()) {
            stringBuilder.append("&vin=").append(vin);
        }
        if (stopTime != null && !stopTime.isEmpty()) {
            stringBuilder.append("&stoptime=").append(stopTime);
        }
        if (lastVin != null && !lastVin.isEmpty()) {
            stringBuilder.append("&lastVin=").append(lastVin);
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
                GetVehiclePositionResponse body = clientResponse.bodyToMono(GetVehiclePositionResponse.class).block();
                return ResponseEntity.status(statusCode).body(body);
            }
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }




}
