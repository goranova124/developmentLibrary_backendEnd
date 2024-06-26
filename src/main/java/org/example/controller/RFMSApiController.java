package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.business.*;
import org.example.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = {"https://gentle-cliff-093aa731e.5.azurestaticapps.net/","https://www.paccarconnectdeveloperlibrary.com","https://paccarconnectdeveloperlibrary.com"},allowedHeaders = "*")
@RequestMapping("/vehicles")
@AllArgsConstructor
public class RFMSApiController {

    private final GetVehiclesUseCase getVehiclesUseCase;
    private final GetVehiclePositionByLatestOnlyUseCase getVehiclePositionByLatestOnlyUseCase;
    private final GetVehiclePositionByStartTimeOnlyUseCase getVehiclePositionByStartTimeOnlyUseCase;
    private final AuthorizationUseCase authorizationUseCase;
    private final GetVehicleStatusByLatestOnlyUseCase getVehicleStatusByLatestOnlyUseCase;
    private final GetVehicleStatusByStarttimeOnlyUseCase getVehicleStatusByStarttimeOnlyUseCase;
    private final GetMoreDataUseCase getMoreDataUseCase;

    @CrossOrigin(origins = {"https://gentle-cliff-093aa731e.5.azurestaticapps.net/","https://www.paccarconnectdeveloperlibrary.com","https://paccarconnectdeveloperlibrary.com"})
    @GetMapping
    public ResponseEntity<GetVehicleResponse> getVehicles(@RequestHeader("Authorization") String authorization,
                                                @RequestHeader("Accept") String accept,
                                                @RequestHeader("ContentType") String contentType) {
        return getVehiclesUseCase.getVehicles(authorization, accept, contentType);
    }


    @CrossOrigin(origins = {"https://gentle-cliff-093aa731e.5.azurestaticapps.net/","https://www.paccarconnectdeveloperlibrary.com","https://paccarconnectdeveloperlibrary.com"})
    @GetMapping("positions/latestOnly")
    public ResponseEntity<String> getVehiclePositionsByLatestOnly(
            @RequestHeader(name = "vin", required = false) String vin,
            @RequestHeader(value = "triggerFilter", required = false) String triggerFilter,
            @RequestHeader(value = "dateType", required = false) String dateType,
            @RequestHeader("Authorization") String authorization,
            @RequestHeader("accept") String accept) {
        return getVehiclePositionByLatestOnlyUseCase.getVehiclesPositionByLatestOnly(authorization, triggerFilter, dateType, vin, accept);
    }

    @CrossOrigin(origins = {"https://gentle-cliff-093aa731e.5.azurestaticapps.net/","https://www.paccarconnectdeveloperlibrary.com","https://paccarconnectdeveloperlibrary.com"})
    @GetMapping("positions/starttime")
    public ResponseEntity<GetVehiclePositionResponse> getVehiclePositionsByStartTime(
            @RequestHeader(name = "vin", required = false) String vin,
            @RequestHeader(name = "starttime", required = false) String starttime,
            @RequestHeader(name = "stoptime", required = false) String stoptime,
            @RequestHeader(value = "triggerFilter", required = false) String triggerFilter,
            @RequestHeader(value = "dateType", required = false) String dateType,
            @RequestHeader(value = "lastVin", required = false) String lastVin,
            @RequestHeader("Authorization") String authorization,
            @RequestHeader("accept") String accept) {
        return getVehiclePositionByStartTimeOnlyUseCase.getVehiclesPositionByStartTime
                (authorization, triggerFilter, dateType, vin, accept, starttime, stoptime,lastVin);
    }

    @CrossOrigin(origins = {"https://gentle-cliff-093aa731e.5.azurestaticapps.net/","https://www.paccarconnectdeveloperlibrary.com","https://paccarconnectdeveloperlibrary.com"})
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody final LoginRequest loginRequest) {
        return authorizationUseCase.login(loginRequest);
    }

    @CrossOrigin(origins = {"https://gentle-cliff-093aa731e.5.azurestaticapps.net/","https://www.paccarconnectdeveloperlibrary.com","https://paccarconnectdeveloperlibrary.com"})
    @GetMapping("statuses/latestOnly")
    public ResponseEntity<String> getVehicleStatusesByLatestOnly(
            @RequestHeader(name = "vin", required = false) String vin,
            @RequestHeader(value = "triggerFilter", required = false) String triggerFilter,
            @RequestHeader(value = "contentFilter", required = false) String contentFilter,
            @RequestHeader(value = "datetype", required = false) String dateType,
            @RequestHeader("Authorization") String authorization,
            @RequestHeader("accept") String accept) {
        return getVehicleStatusByLatestOnlyUseCase.getVehiclesStatusesByLatestOnly(authorization,
                triggerFilter, dateType, vin, accept,contentFilter);
    }
    @CrossOrigin(origins = {"https://gentle-cliff-093aa731e.5.azurestaticapps.net/","https://www.paccarconnectdeveloperlibrary.com","https://paccarconnectdeveloperlibrary.com"})
    @GetMapping("statuses/starttime")
    public ResponseEntity<String> getVehicleStatusesByStarttime(
            @RequestHeader(name = "vin", required = false) String vin,
            @RequestHeader(name = "starttime", required = false) String starttime,
            @RequestHeader(name = "stoptime", required = false) String stoptime,
            @RequestHeader(value = "triggerFilter", required = false) String triggerFilter,
            @RequestHeader(value = "contentFilter", required = false) String contentFilter,
            @RequestHeader(value = "dateType", required = false) String dateType,
            @RequestHeader("Authorization") String authorization,
            @RequestHeader("accept") String accept) {
        return getVehicleStatusByStarttimeOnlyUseCase.getVehiclesStatusesByStarttime(authorization,triggerFilter,dateType,vin,accept,contentFilter,stoptime,starttime);
    }

    @CrossOrigin(origins = {"https://gentle-cliff-093aa731e.5.azurestaticapps.net/","https://www.paccarconnectdeveloperlibrary.com","https://paccarconnectdeveloperlibrary.com"})
    @GetMapping("moreData")
    public ResponseEntity<String> getMoreData(
            @RequestHeader(name = "url", required = true) String url,
            @RequestHeader("Authorization") String authorization,
            @RequestHeader("accept") String accept)  {
        return getMoreDataUseCase.getMoreData(url, authorization, accept);
    }

}
