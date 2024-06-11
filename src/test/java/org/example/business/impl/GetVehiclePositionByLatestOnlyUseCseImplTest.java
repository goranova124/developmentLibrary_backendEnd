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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GetVehiclePositionByLatestOnlyUseCseImplTest {


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
    private GetVehiclePositionByLatestOnlyUseCseImpl useCase;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetVehiclesStatusesByLatestOnly_Unauthorized() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "bearerToken");
        headers.add("Accept", "application/json");

        String authorization = "bearerToken";
        String triggerFilter = "filter";
        String dataType = "received";
        String vin = "123";
        String accept = "application/json";
        String contentFilter = "Contentfilter";
        String stoptime = "stoptime";
        String starttime = "starttime";

        String url = "https://api.connect.daf.com/rfms/vehiclestatuses?" +
                "starttime=" + starttime +
                "&triggerFilter=" + triggerFilter +
                "&dataType=" + dataType +
                "&vin=" + vin +
                "&contentFilter=" + contentFilter +
                "&stoptime=" + stoptime;
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(eq(url))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.headers(any())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.exchange()).thenReturn(Mono.just(responseSpec));
        when(responseSpec.bodyToMono(String.class)).thenReturn(responseBodyMono);
        when(responseBodyMono.block()).thenReturn("response-body");
        HttpStatus statusCode = HttpStatus.OK;

        ResponseEntity<String> actualResponse = useCase.getVehiclesPositionByLatestOnly(
                authorization, dataType, triggerFilter, vin, accept);
        assertEquals(actualResponse.getStatusCode(),statusCode.UNAUTHORIZED);
    }


}

