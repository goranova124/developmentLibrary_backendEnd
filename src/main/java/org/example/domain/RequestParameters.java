package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestParameters {
    private String parameterName;
    private String parameterType;
    private String parameterDescription;
    private String parameterExample;
    private boolean required;



}
