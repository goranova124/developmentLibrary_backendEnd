package org.example.business.impl;

import org.example.domain.RequestParameters;
import org.example.persistence.entity.RequestParametersEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RequestParameterConverterTest {

    @Test
    void convert() {
        RequestParametersEntity requestParametersEntity= RequestParametersEntity.builder().parameterRequired(true)
                .parameterExample("VIN")
                .parameterDescription("Unique number").parameterName("VIN")
                .parameterType("String").build();
        RequestParameters requestParameters=RequestParameterConverter.convert(requestParametersEntity);
        assertEquals(requestParameters.getParameterDescription(),requestParametersEntity.getParameterDescription());

    }
    @Test
    void constructorTest() {
        RequestParameterConverter converter = new RequestParameterConverter();
        assertNotNull(converter);
    }
}