package org.example.business.impl;

import org.example.domain.GetVehicleResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class GetVehicleUseCaseImplTest {
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
    private GetVehicleUseCaseImpl useCase;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getVehicles() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "bearerToken");
        headers.add("Accept", "application/json");

        String authorization = "bearerToken";
        String content = "content";
        String accept = "application/json";

        String url = "https://api.connect.daf.com/rfms/vehicles?";
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(eq(url))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.headers(any())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.exchange()).thenReturn(Mono.just(responseSpec));
        when(responseSpec.bodyToMono(String.class)).thenReturn(responseBodyMono);
        when(responseBodyMono.block()).thenReturn("response-body");

        ResponseEntity<String> expectedResponse = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("");
        ResponseEntity<GetVehicleResponse> actualResponse = useCase.getVehicles(
                authorization, accept, content);
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
    }

//    @Test
//    public void testGetVehicles_PositiveResponse() {
//        String bearerToken = "Bearer xxx";
//        String accept = "application/json";
//        String contentType = "application/json";
//
//        // Mock the response
//        GetVehicleResponse expectedResponse = new GetVehicleResponse();
//        ResponseEntity<GetVehicleResponse> expectedEntity = ResponseEntity.ok(expectedResponse);
//
//        ClientResponse clientResponse = ClientResponse.create(HttpStatus.OK)
////                .body(expectedResponse)
//                .build();
//
//
//        when(webClient.get()
//                .uri("https://api.connect.daf.com/rfms/vehicles")
//                .headers(h -> {
//                    h.add("Content-Type", contentType);
//                    h.add("Authorization", bearerToken);
//                    h.add("Accept", accept);
//                })
//                .exchangeToMono(response -> {
//                    if (response.statusCode().isError()) {
//                        return response.createException().flatMap(Mono::error);
//                    } else {
//                        return Mono.just(response);
//                    }
//                })
//                .block())
//                .thenReturn(clientResponse);
//
//        ResponseEntity<GetVehicleResponse> responseEntity = useCase.getVehicles(bearerToken, accept, contentType);
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals(expectedResponse, responseEntity.getBody());
//    }
}