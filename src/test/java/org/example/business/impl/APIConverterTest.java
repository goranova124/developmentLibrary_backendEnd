package org.example.business.impl;

import org.example.domain.API;
import org.example.persistence.entity.APIEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class APIConverterTest {

    @Test
    void convert() {
        APIEntity apiEntity = APIEntity.builder().errorCodeEntities(new ArrayList<>()).languageEntities(new ArrayList<>())
                .apiType("GET").apiHeader("GET_VEHICLES").apiURL("api.com").apiFunction("GET").apiVersion("1").apiDescription("description")
                .responseParameterEntities(new ArrayList<>()).requestParametersList(new ArrayList<>()).id(1l).build();
        API api = APIConverter.convert(apiEntity);
        assertEquals(api.getApiDescription(),apiEntity.getApiDescription());
    }
    @Test
    void constructorTest() {
        APIConverter converter = new APIConverter();
        assertNotNull(converter);
    }
}