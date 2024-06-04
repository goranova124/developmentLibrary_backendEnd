package org.example.business.impl;

import org.example.domain.ErrorCode;
import org.example.persistence.entity.ErrorCodeEntity;

public class ErrorCodeConverter {
    public static ErrorCode convert (ErrorCodeEntity errorCodeEntity){
        return ErrorCode.builder().errorCode(errorCodeEntity.getErrorCode()).description(errorCodeEntity.getDescription()).possibleReason(errorCodeEntity.getPossibleReason()).build();
    }
}
