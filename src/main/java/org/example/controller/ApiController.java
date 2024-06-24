package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.business.GetAPIDetailsUseCase;
import org.example.business.GetAPIUseCase;
import org.example.domain.GetAPIDetailsResponse;
import org.example.domain.GetAPISResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


@RestController
@CrossOrigin(origins = {"https://gentle-cliff-093aa731e.5.azurestaticapps.net/","www.paccarconnectdeveloperlibrary.com"},allowedHeaders = "*")
@RequestMapping("/apis")
@AllArgsConstructor
public class ApiController {
    private final GetAPIUseCase getAPIsUseCase;
    private final GetAPIDetailsUseCase getAPIUseCase;
    @CrossOrigin(origins = {"https://gentle-cliff-093aa731e.5.azurestaticapps.net/","www.paccarconnectdeveloperlibrary.com"})
    @GetMapping
    public ResponseEntity<Object> getApis() throws SQLException {
        GetAPISResponse api = getAPIsUseCase.getApiResponse();
        return ResponseEntity.status(HttpStatus.OK).body(api);
    }
    @CrossOrigin(origins = {"https://gentle-cliff-093aa731e.5.azurestaticapps.net/","www.paccarconnectdeveloperlibrary.com"})
    @GetMapping("/detailsApi")
    public ResponseEntity<Object> getApiByName(@RequestParam String name) throws SQLException {
        GetAPIDetailsResponse api = getAPIUseCase.getAPIDetails(name);
        return ResponseEntity.status(HttpStatus.OK).body(api);
    }



}
