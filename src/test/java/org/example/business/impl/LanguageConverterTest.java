package org.example.business.impl;

import net.snowflake.client.jdbc.internal.apache.commons.codec.language.bm.Lang;
import org.example.domain.API;
import org.example.domain.Language;
import org.example.persistence.entity.APIEntity;
import org.example.persistence.entity.LanguageEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LanguageConverterTest {
    @Test
    void convert() {


        APIEntity apiEntity = APIEntity.builder().errorCodeEntities(new ArrayList<>()).languageEntities(new ArrayList<>())
                .apiType("GET").apiHeader("GET_VEHICLES").apiURL("api.com").apiFunction("GET").apiVersion("1").apiDescription("description")
                .responseParameterEntities(new ArrayList<>()).requestParametersList(new ArrayList<>()).id(1l).build();
        LanguageEntity entity=LanguageEntity.builder().language("JAVA")
                .api(apiEntity).example("Hello").build();
        Language language = LanguageConverter.convert(entity);
        assertEquals(language.getLanguage(),entity.getLanguage());
    }
    @Test
    void constructorTest() {
        LanguageConverter converter = new LanguageConverter();
        assertNotNull(converter);
    }
}