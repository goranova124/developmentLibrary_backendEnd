package org.example.controller;

import static org.junit.jupiter.api.Assertions.*;


import org.example.business.GetAPIDetailsUseCase;
import org.example.business.GetAPIUseCase;
import org.example.domain.GetAPIDetailsResponse;
import org.example.domain.GetAPISResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;

import static org.mockito.Mockito.*;

class ApiControllerTest {

    private ApiController apiController;

    @Mock
    private GetAPIUseCase getAPIsUseCase;

    @Mock
    private GetAPIDetailsUseCase getAPIUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        apiController = new ApiController(getAPIsUseCase, getAPIUseCase);
    }

    @Test
    void getApis_ReturnsResponseEntityWithSuccess() throws SQLException {
        // Arrange
        GetAPISResponse apiResponse = new GetAPISResponse();
        ResponseEntity<Object> expectedResponseEntity = ResponseEntity.status(HttpStatus.OK).body(apiResponse);

        when(getAPIsUseCase.getApiResponse()).thenReturn(apiResponse);

        // Act
        ResponseEntity<Object> actualResponseEntity = apiController.getApis();

        // Assert
        verify(getAPIsUseCase, times(1)).getApiResponse();
        verifyNoMoreInteractions(getAPIsUseCase);
        assertSame(expectedResponseEntity.getStatusCode(), actualResponseEntity.getStatusCode());
    }

    @Test
    void getApiByName_ReturnsResponseEntityWithSuccess() throws SQLException {
        // Arrange
        String name = "apiName";
        GetAPIDetailsResponse apiResponse = new GetAPIDetailsResponse();
        ResponseEntity<Object> expectedResponseEntity = ResponseEntity.status(HttpStatus.OK).body(apiResponse);

        when(getAPIUseCase.getAPIDetails(name)).thenReturn(apiResponse);

        // Act
        ResponseEntity<Object> actualResponseEntity = apiController.getApiByName(name);

        // Assert
        verify(getAPIUseCase, times(1)).getAPIDetails(name);
        verifyNoMoreInteractions(getAPIUseCase);
        assertSame(expectedResponseEntity.getStatusCode(), actualResponseEntity.getStatusCode());
    }
}
