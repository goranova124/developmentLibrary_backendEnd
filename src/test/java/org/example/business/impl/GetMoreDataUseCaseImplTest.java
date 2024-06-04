package org.example.business.impl;

import org.example.domain.GetVehicleResponse;
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

class GetMoreDataUseCaseImplTest {
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
    private GetMoreDataUseCaseImpl useCase;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getMoreData() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "bearerToken");
        headers.add("Accept", "application/json");

        String authorization = "bearerToken";
        String accept = "application/json";

        String url = "/rfms/vehiclepositions?starttime=2024-04-19T13:46:28.069Z&lastVin=XLRTEF5300G450805&datetype=received?";
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(eq(url))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.headers(any())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.exchange()).thenReturn(Mono.just(responseSpec));
        when(responseSpec.bodyToMono(String.class)).thenReturn(responseBodyMono);
        when(responseBodyMono.block()).thenReturn("response-body");

        ResponseEntity<String> expectedResponse = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("");
        ResponseEntity<String> actualResponse = useCase.getMoreData(url,
                authorization, accept);
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
    }
}