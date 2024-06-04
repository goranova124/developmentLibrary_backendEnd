package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseParameters {
    private String parameterName;
    private String parameterType;
    private String parameterDescription;
    private String parameterExample;
    private List<Features> featuresList;



}
