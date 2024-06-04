//package org.example.business.impl;
//
//import org.example.domain.GetAPIDetailsResponse;
//import org.example.persistence.APIRepository;
//import org.example.persistence.entity.APIEntity;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//class GetAPIDetailsUseCaseImplTest {
//    @Mock
//    private APIRepository apiRepository;
//    @InjectMocks
//    private GetAPIDetailsUseCaseImpl getAPIDetailsUseCase;
//
//    @Test
//    void getApiDetailsTest() {
//        APIEntity apiEntity = APIEntity.builder().errorCodeEntities(new ArrayList<>()).languageEntities(new ArrayList<>())
//                .apiType("GET").apiHeader("GET_VEHICLES").apiURL("api.com").apiFunction("GET").apiVersion("1").apiDescription("description")
//                .responseParameterEntities(new ArrayList<>()).requestParametersList(new ArrayList<>()).id(1l).build();
//        when(apiRepository.getApiDetails("GET_VEHICLES")).thenReturn(Optional.of(apiEntity));
//        GetAPIDetailsResponse response=getAPIDetailsUseCase.getAPIDetails("GET_VEHICLES");
//        assertTrue(response.getApi().isPresent());
//        verify(apiRepository.getApiDetails("GET_VEHICLES"));
//
//    }
//
//
//}