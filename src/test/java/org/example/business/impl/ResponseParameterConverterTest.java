package org.example.business.impl;

import org.example.domain.ResponseParameters;
import org.example.persistence.entity.ResponseParameterEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ResponseParameterConverterTest {

    @Test
    void convert() {
        ResponseParameterEntity response= ResponseParameterEntity.builder()
                .featureEntities(new ArrayList<>()).parameterExample("VIN")
                .parameterDescription("Unique number").parameterName("VIN")
                .id(1L).parameterType("String").build();
        ResponseParameters responseParameters=ResponseParameterConverter.convert(response);
        assertEquals(responseParameters.getParameterDescription(),response.getParameterDescription());

    }
    @Test
    void constructorTest() {
        ResponseParameterConverter converter = new ResponseParameterConverter();
        assertNotNull(converter);
    }
}