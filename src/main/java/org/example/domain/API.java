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
public class API {
    private String apiFunction;
    private String apiDescription;
    private String apiURL;
    private String apiType;
    private String apiVersion;
    private String apiHeader;
    private List<RequestParameters> requestParametersList;
    private List<ResponseParameters> responseParametersList;
    private List<Language> languages;
    private List<ErrorCode> errorCodes;

}
