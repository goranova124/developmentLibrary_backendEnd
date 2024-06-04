package org.example.business.impl;

import org.example.domain.GetAPIDetailsResponse;
import org.example.domain.GetAPISResponse;
import org.example.persistence.APIRepository;
import org.example.persistence.entity.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class GetAPISUseCaseImplTest {
    @Mock
    private APIRepository apiRepository;
    @InjectMocks
    private GetAPISUseCaseImpl getAPISUseCase;
    @Test
    void getApiResponse() throws SQLException {
        MockitoAnnotations.openMocks(this);

        ErrorCodeEntity errorCodeEntity = ErrorCodeEntity.builder().errorCode("200").id(1).api(new APIEntity()).build();
        List<ErrorCodeEntity> errorCodeEntities=new ArrayList<>();
        errorCodeEntities.add(errorCodeEntity);
        APIEntity apiEntity = APIEntity.builder().errorCodeEntities(new ArrayList<>()).languageEntities(new ArrayList<>())
                .apiType("GET").apiHeader("GET_VEHICLES").apiURL("api.com").apiFunction("GET").apiVersion("1").apiDescription("description")
                .responseParameterEntities(new ArrayList<>()).requestParametersList(new ArrayList<>()).id(1l).build();
        LanguageEntity languageEntity=LanguageEntity.builder().language("JAVA")
                .api(apiEntity).example("Hello").build();
        List<LanguageEntity> languageEntities=new ArrayList<>();
        languageEntities.add(languageEntity);
        RequestParametersEntity requestParametersEntity= RequestParametersEntity.builder().parameterRequired(true)
                .parameterExample("VIN").id(1).api(apiEntity)
                .parameterDescription("Unique number").parameterName("VIN")
                .parameterType("String").build();
        ResponseParameterEntity responseParameterEntity= ResponseParameterEntity.builder()
                .featureEntities(new ArrayList<>()).parameterExample("VIN")
                .parameterDescription("Unique number").parameterName("VIN").api(apiEntity)
                .id(1L).parameterType("String").build();

        List<RequestParametersEntity> requestParametersEntities=new ArrayList<>();
        List<ResponseParameterEntity> responseParameterEntities=new ArrayList<>();
        requestParametersEntities.add(requestParametersEntity);
        responseParameterEntities.add(responseParameterEntity);
        APIEntity apiEntity1 = APIEntity.builder().errorCodeEntities(errorCodeEntities).languageEntities(languageEntities)
                .apiType("GET").apiHeader("GET_VEHICLES").apiURL("api.com").apiFunction("GET").apiVersion("1").apiDescription("description")
                .responseParameterEntities(responseParameterEntities).requestParametersList(requestParametersEntities).id(1l).build();
        APIEntity apiEntity2 = APIEntity.builder().errorCodeEntities(errorCodeEntities).languageEntities(languageEntities)
                .apiType("POST").apiHeader("AUTHORIZATION").apiURL("api.com").apiFunction("POST").apiVersion("1").apiDescription("description")
                .responseParameterEntities(responseParameterEntities).requestParametersList(requestParametersEntities).id(1l).build();
        List<APIEntity> apiEntities=new ArrayList<>();
        apiEntities.add(apiEntity1);
        apiEntities.add(apiEntity2);
        when(apiRepository.getAPIS()).thenReturn(apiEntities);
        GetAPISResponse response =getAPISUseCase.getApiResponse();
        assertEquals(2,response.getApiEntity().size());
        verify(apiRepository).getAPIS();
    }
}