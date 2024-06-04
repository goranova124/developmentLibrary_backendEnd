package org.example.business.impl;

import org.example.domain.Features;
import org.example.persistence.entity.FeatureEntity;

public class FeatureConverter {
    public static Features convert (FeatureEntity featureEntity){

        return Features.builder()
                .featureDescription(featureEntity.getFeatureDescription())
                .featureName(featureEntity.getFeatureName())
                .featureType(featureEntity.getFeatureType())
                .build();
    }
}
