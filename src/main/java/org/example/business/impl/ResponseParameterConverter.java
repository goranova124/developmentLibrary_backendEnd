package org.example.business.impl;

import org.example.domain.ResponseParameters;
import org.example.persistence.entity.ResponseParameterEntity;

import java.util.stream.Collectors;

public class ResponseParameterConverter {
    public static ResponseParameters convert (ResponseParameterEntity responseParameterEntity){

        return ResponseParameters.builder().parameterName(responseParameterEntity.getParameterName())
                .featuresList(responseParameterEntity.getFeatureEntities().stream().map(FeatureConverter::convert).collect(Collectors.toList()))
                .parameterDescription(responseParameterEntity.getParameterDescription())
                .parameterExample(responseParameterEntity.getParameterExample())
                .parameterType(responseParameterEntity.getParameterType())
                .parameterName(responseParameterEntity.getParameterName())
                .build();
    }
}
