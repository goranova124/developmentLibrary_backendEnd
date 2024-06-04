package org.example.business.impl;
import org.example.domain.API;
import org.example.persistence.entity.APIEntity;
import java.util.stream.Collectors;

public class APIConverter {
    public static API convert (APIEntity apiEntity){
        return API.builder()
                .apiDescription(apiEntity.getApiDescription())
                .apiURL(apiEntity.getApiURL())
                .apiFunction(apiEntity.getApiFunction())
                .apiType(apiEntity.getApiType())
                .apiHeader(apiEntity.getApiHeader())
                .apiVersion(apiEntity.getApiVersion())
                .requestParametersList(apiEntity.getRequestParametersList().stream().map(RequestParameterConverter::convert).collect(Collectors.toList()))
                .responseParametersList(apiEntity.getResponseParameterEntities().stream().map(ResponseParameterConverter::convert).collect(Collectors.toList()))
                .errorCodes(apiEntity.getErrorCodeEntities().stream().map(ErrorCodeConverter::convert).collect(Collectors.toList()))
                .languages(apiEntity.getLanguageEntities().stream().map(LanguageConverter::convert).collect(Collectors.toList()))
                .build();
    }
}
