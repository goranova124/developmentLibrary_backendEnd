package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetarderTorqueClass {
    private double from;
    private double to;
    private Integer seconds;
    private Integer meters;
    private Integer miliLetres;
}
