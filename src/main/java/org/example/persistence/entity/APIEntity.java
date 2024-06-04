package org.example.persistence.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class APIEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JacksonXmlProperty(localName = "API_FUNCTION")
    private String apiFunction;

    @JacksonXmlProperty(localName = "API_DESC")
    private String apiDescription;

    @JacksonXmlProperty(localName = "API_URL")
    private String apiURL;

    @JacksonXmlProperty(localName = "API_TYPE")
    private String apiType;

    @JacksonXmlProperty(localName = "API_HEADER")
    private String apiHeader;

    @JacksonXmlProperty(localName = "API_VERSION")
    private String apiVersion;


    @OneToMany(mappedBy = "api", cascade = CascadeType.ALL)
    @XmlElementWrapper(name = "requests_parameter_entities")
    @XmlElement(name = "requests_parameter_entity")
    private List<RequestParametersEntity> requestParametersList;


    @OneToMany(mappedBy = "api", cascade = CascadeType.ALL)
    @XmlElementWrapper(name = "response_parameter_entities")
    @XmlElement(name = "response_parameter_entity")
    private List<ResponseParameterEntity> responseParameterEntities;

    @OneToMany(mappedBy = "api", cascade = CascadeType.ALL)
    @XmlElementWrapper(name = "language_entities")
    @XmlElement(name = "language_entity")
    private List<LanguageEntity> languageEntities;

    @OneToMany(mappedBy = "api", cascade = CascadeType.ALL)
    @XmlElementWrapper(name = "error_codes_entities")
    @XmlElement(name = "error_codes_entity")
    private List<ErrorCodeEntity> errorCodeEntities;

}
