package org.example.business.impl;

import org.example.domain.Features;
import org.example.persistence.entity.FeatureEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeatureConverterTest {

    @Test
    void convert() {
        FeatureEntity entity = FeatureEntity.builder().featureName("vin")
                .featureDescription("Identification number").featureType("String")
                .id(1L).build();
        Features feature = FeatureConverter.convert(entity);
        assertEquals(feature.getFeatureName(),entity.getFeatureName());
    }
    @Test
    void constructorTest() {
        FeatureConverter converter = new FeatureConverter();
        assertNotNull(converter);
    }
}