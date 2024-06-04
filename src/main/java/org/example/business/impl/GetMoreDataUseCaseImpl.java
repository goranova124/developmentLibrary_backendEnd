package org.example.business.impl;

import lombok.AllArgsConstructor;
import org.example.business.GetMoreDataUseCase;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class GetMoreDataUseCaseImpl implements GetMoreDataUseCase {

    @Override
    public ResponseEntity<String> getMoreData(String url, String authorization, String accept)  {
        WebClient webClient = WebClient.create();
        HttpHeaders headers = new HttpHeaders();

        headers.add("Authorization", authorization);
        headers.add("Accept", accept);


        ClientResponse clientResponse = webClient.get()
                .uri("https://api.connect.daf.com" + url)
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
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}

