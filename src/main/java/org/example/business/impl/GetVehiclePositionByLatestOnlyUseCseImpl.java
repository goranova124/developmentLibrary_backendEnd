package org.example.business.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.business.GetVehiclePositionByLatestOnlyUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service

public class GetVehiclePositionByLatestOnlyUseCseImpl implements GetVehiclePositionByLatestOnlyUseCase {
    private static final Logger logger = LoggerFactory.getLogger(GetVehiclePositionByLatestOnlyUseCseImpl.class);



    @Override
    public ResponseEntity<String> getVehiclesPositionByLatestOnly(String authorization, String triggerFilter, String dataType, String vin, String accept) {
        ObjectMapper objectMapper = new ObjectMapper();
        WebClient webClient = WebClient.create();
        HttpHeaders headers = new HttpHeaders();

//        headers.add("Content-Type", "application/json");
        headers.add("Authorization", authorization);
        headers.add("Accept", accept);
        StringBuilder stringBuilder=new StringBuilder("https://api.connect.daf.com/rfms/vehiclepositions?latestOnly=true");
        if (triggerFilter!=null && !triggerFilter.trim().isEmpty()){
            stringBuilder.append("&triggerFilter=").append(triggerFilter);        }
        if (dataType!=null && !dataType.isEmpty()){
            stringBuilder.append("&dataType=").append(dataType);
        }
        if (vin!=null && !vin.isEmpty()){
        stringBuilder.append("&vin=").append(vin);
        }
        ClientResponse clientResponse = webClient.get()
                .uri(stringBuilder.toString())
                .headers(h -> h.addAll(headers))
                .exchange()
                .block();
        if (clientResponse != null) {
            HttpStatus statusCode = clientResponse.statusCode();
            if (statusCode.isError()) {
                logger.error("Failed to login. Status code: {}", statusCode);
                String body = clientResponse.bodyToMono(String.class).block();
                return ResponseEntity.status(statusCode).body(null);
            } else {
                String body = clientResponse.bodyToMono(String.class).block();
                return ResponseEntity.status(statusCode).body(body);
            }
        } else {
            logger.error("Failed to receive response from external API");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to receive response from external API");
        }

    }
    private Mono<? extends Throwable> handleErrorResponse(ClientResponse clientResponse) {
        HttpStatus statusCode = clientResponse.statusCode();
        logger.error("Failed to fetch vehicles. Status code: {}", statusCode);
        return Mono.error(new Error(" " + statusCode));
    }


}
