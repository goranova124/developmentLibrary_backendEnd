package org.example.business.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.business.GetVehiclesUseCase;
import org.example.domain.GetVehicleResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GetVehicleUseCaseImpl implements GetVehiclesUseCase {


    @Override
    public ResponseEntity<GetVehicleResponse> getVehicles(String bearerToken, String accept, String contentType) {
        WebClient webClient = WebClient.create();
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Type", contentType);
        headers.add("Authorization", bearerToken);
        headers.add("Accept", accept);
        ClientResponse clientResponse = webClient.get()
                .uri("https://api.connect.daf.com/rfms/vehicles")
                .headers(h -> h.addAll(headers))
                .exchange()
                .block();
        if (clientResponse != null) {
            HttpStatus statusCode = clientResponse.statusCode();
            if (statusCode.isError()) {
                return ResponseEntity.status(statusCode).body(null);
            } else {
                GetVehicleResponse body = clientResponse.bodyToMono(GetVehicleResponse.class).block();
                return ResponseEntity.status(statusCode).body(body);
            }
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }


}
