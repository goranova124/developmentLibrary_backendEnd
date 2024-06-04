package org.example.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "request_parameters")
@AllArgsConstructor
@NoArgsConstructor
public class RequestParametersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String parameterName;
    private String parameterType;
    private String parameterDescription;
    private String parameterExample;
    private boolean parameterRequired;
    @ManyToOne
    @JoinColumn(name = "api_id")
    private APIEntity api;



}
