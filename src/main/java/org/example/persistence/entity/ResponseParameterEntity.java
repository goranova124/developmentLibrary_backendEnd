package org.example.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "response_parameters")
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "response_parameter")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseParameterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlAttribute
    private Long id;

    @ManyToOne
    @JoinColumn(name = "api_id")
    @XmlTransient
    private APIEntity api;

    private String parameterName;
    private String parameterType;
    private String parameterDescription;
    private String parameterExample;

    @OneToMany(mappedBy = "responseParameterEntity", cascade = CascadeType.ALL)
    @XmlElementWrapper(name = "feature_entities")
    @XmlElement(name = "feature_entity")
    private List<FeatureEntity> featureEntities;
}
