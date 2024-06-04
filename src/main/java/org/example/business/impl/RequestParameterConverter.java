package org.example.business.impl;

import org.example.domain.RequestParameters;
import org.example.persistence.entity.RequestParametersEntity;

public class RequestParameterConverter {
    public static RequestParameters convert (RequestParametersEntity requestParameterEntity){

        return RequestParameters.builder()
                .parameterExample(requestParameterEntity.getParameterExample())
                .parameterName(requestParameterEntity.getParameterName())
                .parameterDescription(requestParameterEntity.getParameterDescription())
                .parameterType(requestParameterEntity.getParameterType())
                .required(requestParameterEntity.isParameterRequired())
                .build();
    }
}
