package org.example.business.impl;

import org.example.domain.GetVehiclePositionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GetVehiclePositionByStartTimeOnlyUseCseImplTest {

    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;
    @Mock
    private WebClient.ResponseSpec responseSpec;

    @Mock
    private Mono<String> responseBodyMono;

    @InjectMocks
    private GetVehiclePositionByStartTimeOnlyUseCseImpl useCase;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void getVehiclesPositionByStartTime() {
        // Arrange
        String authorization = "Bearer token";
        String triggerFilter = "filter";
        String dataType = "type";
        String vin = "vin";
        String accept = MediaType.APPLICATION_JSON_VALUE;
        String startTime = "2022-01-01T00:00:00Z";
        String stopTime = "2022-01-02T00:00:00Z";
        String contentFilter = "Contentfilter";

        String lastVin = "lastVin";
        String url = "https://api.connect.daf.com/rfms/vehiclestatuses?" +
                "starttime=" + startTime +
                "&triggerFilter=" + triggerFilter +
                "&dataType=" + dataType +
                "&vin=" + vin +
                "&contentFilter=" + contentFilter +
                "&stoptime=" + stopTime;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", authorization);
        headers.add("Accept", accept);

        GetVehiclePositionResponse response = new GetVehiclePositionResponse();
//        ResponseEntity<GetVehiclePositionResponse> expectedResponseEntity = (ResponseEntity<GetVehiclePositionResponse>) ResponseEntity.status(HttpStatus.UNAUTHORIZED);
//        ResponseEntity<String> expectedResponse = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("");


        ClientResponse clientResponse = mock(ClientResponse.class);
        HttpStatus statusCode = HttpStatus.OK;

        when(clientResponse.statusCode()).thenReturn(statusCode);
        when(clientResponse.bodyToMono(GetVehiclePositionResponse.class)).thenReturn(Mono.just(response));
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(eq(url))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.headers(any())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.exchange()).thenReturn(Mono.just(responseSpec));
        when(responseSpec.bodyToMono(String.class)).thenReturn(responseBodyMono);


        ResponseEntity<GetVehiclePositionResponse> actualResponseEntity = useCase.getVehiclesPositionByStartTime(
                authorization, triggerFilter, dataType, vin, accept, startTime, stopTime, lastVin);

        assertEquals(actualResponseEntity.getStatusCode(), statusCode.UNAUTHORIZED);
    }
}