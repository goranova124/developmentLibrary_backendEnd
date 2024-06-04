package org.example.business.impl;

import org.example.business.AuthorizationUseCase;
import org.example.domain.LoginRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Base64;

@Service
public class AuthorizationUseCaseImpl implements AuthorizationUseCase {


    @Override
    public ResponseEntity<String> login(LoginRequest request) {
        WebClient webClient = WebClient.create();
        HttpHeaders headers = new HttpHeaders();
        String credentials = request.getEmail() + ":" + request.getPassword();
        String base64Credentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        headers.setBasicAuth(base64Credentials);
        ClientResponse clientResponse = webClient.post()
                .uri("https://api.connect.daf.com/rfms/token")
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
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to receive response from external API");
        }
    }


}
