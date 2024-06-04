package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TriggerType {
    private String triggerType;
    private String context;
    private String triggerInfo;
    private String ptoId;
    private TellTaleInfo tellTaleInfo;
    private DriveridObject driverId;

}
