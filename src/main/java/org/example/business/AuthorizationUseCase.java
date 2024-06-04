package org.example.business;

import org.example.domain.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface AuthorizationUseCase {
    ResponseEntity<String> login(LoginRequest request);
}
