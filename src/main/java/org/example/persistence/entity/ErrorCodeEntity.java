package org.example.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "errorCodes")
@AllArgsConstructor
@NoArgsConstructor
public class ErrorCodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String errorCode;
    private String description;
    private String possibleReason;
    @ManyToOne
    @JoinColumn(name = "api_id")
    private APIEntity api;

}
