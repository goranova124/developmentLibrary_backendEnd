package org.example.business.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class GetVehicleStatusByLatestOnlyUseCseImplTest {

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
    private GetVehicleStatusByLatestOnlyUseCseImpl useCase;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getVehiclesStatusesByLatestOnly() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "bearerToken");
        headers.add("Accept", "application/json");

        String authorization = "bearerToken";
        String triggerFilter = "filter";
        String dataType = "received";
        String vin = "123";
        String accept = "application/json";
        String contentFilter = "Contentfilter";

        String url = "https://api.connect.daf.com/rfms/vehiclestatuses?" +
                "&triggerFilter=" + triggerFilter +
                "&dataType=" + dataType +
                "&vin=" + vin +
                "&contentFilter=" + contentFilter +
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(eq(url))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.headers(any())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.exchange()).thenReturn(Mono.just(responseSpec));
        when(responseSpec.bodyToMono(String.class)).thenReturn(responseBodyMono);
        when(responseBodyMono.block()).thenReturn("response-body");

        ResponseEntity<String> expectedResponse = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("");
        ResponseEntity<String> actualResponse = useCase.getVehiclesStatusesByLatestOnly(
                authorization, triggerFilter, dataType, vin, accept, contentFilter);
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
    }

}