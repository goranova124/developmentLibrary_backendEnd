package org.example.business.impl;
import org.example.business.AuthorizationUseCase;
import org.example.domain.LoginRequest;
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

import java.util.Base64;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorizationUseCaseImplTest {


    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;
    @Mock
    private Mono<String> responseBodyMono;
    @InjectMocks
    private AuthorizationUseCaseImpl authorizationUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLogin_SuccessfulResponse() {
        LoginRequest request = new LoginRequest("Hackathon_4@daftrucks.com", "Team4Hackathon!");
        String base64Credentials = Base64.getEncoder().encodeToString("test@example.com:password".getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(base64Credentials);

        when(requestHeadersUriSpec.uri(any(String.class))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.headers(any())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.exchange()).thenReturn(Mono.just(responseSpec));
        when(responseBodyMono.block()).thenReturn("clientResponse");
        ResponseEntity<String> response = authorizationUseCase.login(request);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testLogin_ErrorResponse() {
        LoginRequest request = new LoginRequest("test@example.com", "password");
        String base64Credentials = Base64.getEncoder().encodeToString("test@example.com:password".getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(base64Credentials);
        when(requestHeadersUriSpec.uri(any(String.class))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.headers(any())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.exchange()).thenReturn(Mono.just(responseSpec));
        when(responseBodyMono.block()).thenReturn("clientResponse");
        ResponseEntity<String> response = authorizationUseCase.login(request);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }

}
