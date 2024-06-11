package org.example.controller;

import org.example.business.*;
import org.example.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RFMSApiControllerTest {

    private RFMSApiController apiController;

    @Mock
    private GetVehiclesUseCase getVehiclesUseCase;

    @Mock
    private GetVehiclePositionByLatestOnlyUseCase getVehiclePositionByLatestOnlyUseCase;

    @Mock
    private GetVehiclePositionByStartTimeOnlyUseCase getVehiclePositionByStartTimeOnlyUseCase;

    @Mock
    private AuthorizationUseCase authorizationUseCase;

    @Mock
    private GetVehicleStatusByLatestOnlyUseCase getVehicleStatusByLatestOnlyUseCase;

    @Mock
    private GetVehicleStatusByStarttimeOnlyUseCase getVehicleStatusByStarttimeOnlyUseCase;

    @Mock
    private GetMoreDataUseCase getMoreDataUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        apiController = new RFMSApiController(
                getVehiclesUseCase,
                getVehiclePositionByLatestOnlyUseCase,
                getVehiclePositionByStartTimeOnlyUseCase,
                authorizationUseCase,
                getVehicleStatusByLatestOnlyUseCase,
                getVehicleStatusByStarttimeOnlyUseCase,
                getMoreDataUseCase
        );
    }

    @Test
    void getVehicles_ReturnsResponseEntityWithSuccess() {
        // Arrange
        String authorization = "Bearer token";
        String accept = MediaType.APPLICATION_JSON_VALUE;
        String contentType = MediaType.APPLICATION_JSON_VALUE;
        GetVehicleResponse response = new GetVehicleResponse();
        ResponseEntity<GetVehicleResponse> expectedResponseEntity = ResponseEntity.status(HttpStatus.OK).body(response);

        when(getVehiclesUseCase.getVehicles(authorization, accept, contentType)).thenReturn(expectedResponseEntity);

        // Act
        ResponseEntity<GetVehicleResponse> actualResponseEntity = apiController.getVehicles(authorization, accept, contentType);

        // Assert
        verify(getVehiclesUseCase, times(1)).getVehicles(authorization, accept, contentType);
        verifyNoMoreInteractions(getVehiclesUseCase);
        assertEquals(expectedResponseEntity.getStatusCode(), actualResponseEntity.getStatusCode());
    }

    @Test
    void getVehiclePositionsByLatestOnly_ReturnsResponseEntityWithSuccess() {
        // Arrange
        String vin = "VIN123";
        String triggerFilter = "filter";
        String dateType = "type";
        String authorization = "Bearer token";
        String accept = MediaType.APPLICATION_JSON_VALUE;
        ResponseEntity<String> expectedResponseEntity = ResponseEntity.status(HttpStatus.OK).body("response");

        when(getVehiclePositionByLatestOnlyUseCase.getVehiclesPositionByLatestOnly(authorization, triggerFilter, dateType, vin, accept)).thenReturn(expectedResponseEntity);

        // Act
        ResponseEntity<String> actualResponseEntity = apiController.getVehiclePositionsByLatestOnly(vin, triggerFilter, dateType, authorization, accept);

        // Assert
        verify(getVehiclePositionByLatestOnlyUseCase, times(1)).getVehiclesPositionByLatestOnly(authorization, triggerFilter, dateType, vin, accept);
        verifyNoMoreInteractions(getVehiclePositionByLatestOnlyUseCase);
        assertEquals(expectedResponseEntity.getStatusCode(), actualResponseEntity.getStatusCode());
    }

    @Test
    void getVehiclePositionsByStartTime_ReturnsResponseEntityWithSuccess() {
        // Arrange
        String vin = "VIN123";
        String starttime = "2022-01-01T00:00:00Z";
        String stoptime = "2022-01-02T00:00:00Z";
        String triggerFilter = "filter";
        String dateType = "type";
        String lastVin = "lastVin";
        String authorization = "Bearer token";
        String accept = MediaType.APPLICATION_JSON_VALUE;
        GetVehiclePositionResponse response = new GetVehiclePositionResponse();
        ResponseEntity<GetVehiclePositionResponse> expectedResponseEntity = ResponseEntity.status(HttpStatus.OK).body(response);

        when(getVehiclePositionByStartTimeOnlyUseCase.getVehiclesPositionByStartTime(authorization, triggerFilter, dateType, vin, accept, starttime, stoptime, lastVin)).thenReturn(expectedResponseEntity);

        // Act
        ResponseEntity<GetVehiclePositionResponse> actualResponseEntity = apiController.getVehiclePositionsByStartTime(vin, starttime, stoptime, triggerFilter, dateType, lastVin, authorization, accept);

        // Assert
        verify(getVehiclePositionByStartTimeOnlyUseCase, times(1)).getVehiclesPositionByStartTime(authorization, triggerFilter, dateType, vin, accept, starttime, stoptime, lastVin);
        verifyNoMoreInteractions(getVehiclePositionByStartTimeOnlyUseCase);
        assertEquals(expectedResponseEntity.getStatusCode(), actualResponseEntity.getStatusCode());
    }

    @Test
    void login_ReturnsResponseEntityWithSuccess() {
        // Arrange
        LoginRequest loginRequest = new LoginRequest("username", "password");
        ResponseEntity<String> expectedResponseEntity = ResponseEntity.status(HttpStatus.OK).body("response");

        when(authorizationUseCase.login(loginRequest)).thenReturn(expectedResponseEntity);

        // Act
        ResponseEntity<String> actualResponseEntity = apiController.login(loginRequest);

        // Assert
        verify(authorizationUseCase, times(1)).login(loginRequest);
        verifyNoMoreInteractions(authorizationUseCase);
        assertEquals(expectedResponseEntity.getStatusCode(), actualResponseEntity.getStatusCode());
    }

    @Test
    void getVehicleStatusesByLatestOnly_ReturnsResponseEntityWithSuccess() {
        // Arrange
        String vin = "VIN123";
        String triggerFilter = "filter";
        String contentFilter = "contentFilter";
        String dateType = "type";
        String authorization = "Bearer token";
        String accept = MediaType.APPLICATION_JSON_VALUE;
        ResponseEntity<String> expectedResponseEntity = ResponseEntity.status(HttpStatus.OK).body("response");

        when(getVehicleStatusByLatestOnlyUseCase.getVehiclesStatusesByLatestOnly(authorization, triggerFilter, dateType, vin, accept, contentFilter)).thenReturn(expectedResponseEntity);

        // Act
        ResponseEntity<String> actualResponseEntity = apiController.getVehicleStatusesByLatestOnly(vin, triggerFilter, contentFilter, dateType, authorization, accept);

        // Assert
        verify(getVehicleStatusByLatestOnlyUseCase, times(1)).getVehiclesStatusesByLatestOnly(authorization, triggerFilter, dateType, vin, accept, contentFilter);
        verifyNoMoreInteractions(getVehicleStatusByLatestOnlyUseCase);
        assertEquals(expectedResponseEntity.getStatusCode(), actualResponseEntity.getStatusCode());
    }

    @Test
    void getVehicleStatusesByStarttime_ReturnsResponseEntityWithSuccess() {
        // Arrange
        String vin = "VIN123";
        String starttime = "2022-01-01T00:00:00Z";
        String stoptime = "2022-01-02T00:00:00Z";
        String triggerFilter = "filter";
        String contentFilter = "contentFilter";
        String dateType = "type";
        String authorization = "Bearer token";
        String accept = MediaType.APPLICATION_JSON_VALUE;
        ResponseEntity<String> expectedResponseEntity = ResponseEntity.status(HttpStatus.OK).body("response");

        when(getVehicleStatusByStarttimeOnlyUseCase.getVehiclesStatusesByStarttime(authorization, triggerFilter, dateType, vin, accept, contentFilter, stoptime, starttime)).thenReturn(expectedResponseEntity);

        // Act
        ResponseEntity<String> actualResponseEntity = apiController.getVehicleStatusesByStarttime(vin, starttime, stoptime, triggerFilter, contentFilter, dateType, authorization, accept);

        // Assert
        verify(getVehicleStatusByStarttimeOnlyUseCase, times(1)).getVehiclesStatusesByStarttime(authorization, triggerFilter, dateType, vin, accept, contentFilter, stoptime, starttime);
        verifyNoMoreInteractions(getVehicleStatusByStarttimeOnlyUseCase);
        assertEquals(expectedResponseEntity.getStatusCode(), actualResponseEntity.getStatusCode());
    }

    @Test
    void getMoreData_ReturnsResponseEntityWithSuccess() {
        // Arrange
        String url = "https://example.com/data";
        String authorization = "Bearer token";
        String accept = MediaType.APPLICATION_JSON_VALUE;
        ResponseEntity<String> expectedResponseEntity = ResponseEntity.status(HttpStatus.OK).body("response");

        when(getMoreDataUseCase.getMoreData(url, authorization, accept)).thenReturn(expectedResponseEntity);

        // Act
        ResponseEntity<String> actualResponseEntity = apiController.getMoreData(url, authorization, accept);

        // Assert
        verify(getMoreDataUseCase, times(1)).getMoreData(url, authorization, accept);
        verifyNoMoreInteractions(getMoreDataUseCase);
        assertEquals(expectedResponseEntity.getStatusCode(), actualResponseEntity.getStatusCode());
    }
}
