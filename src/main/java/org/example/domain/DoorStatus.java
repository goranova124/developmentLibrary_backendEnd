package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoorStatus {
    private String doorEnabledStatus;
    private String doorOpenStatus;
    private String doorLockStatus;
    private Integer doorNumber;
}
