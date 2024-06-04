package org.example.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "features")
@AllArgsConstructor
@NoArgsConstructor
public class FeatureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "response_parameters_id")
    private ResponseParameterEntity responseParameterEntity;
    private String featureName;
    private String featureType;
    private String featureDescription;


}
