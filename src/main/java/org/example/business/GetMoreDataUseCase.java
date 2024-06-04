package org.example.business;

import org.springframework.http.ResponseEntity;

public interface GetMoreDataUseCase {
    ResponseEntity<String> getMoreData(String url, String authorization, String accept) ;
}
