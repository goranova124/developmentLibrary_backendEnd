package org.example.business.impl;

import org.example.domain.API;
import org.example.domain.ErrorCode;
import org.example.persistence.entity.APIEntity;
import org.example.persistence.entity.ErrorCodeEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ErrorCodeConverterTest {

    @Test
    void convert() {
        ErrorCodeEntity errorCodeEntity = ErrorCodeEntity.builder().errorCode("200").id(1).api(new APIEntity()).build();
        ErrorCode errorCode = ErrorCodeConverter.convert(errorCodeEntity);
        assertEquals(errorCode.getErrorCode(),errorCodeEntity.getErrorCode());
    }
    @Test
    void constructorTest() {
        ErrorCodeConverter converter = new ErrorCodeConverter();
        assertNotNull(converter);
    }
}