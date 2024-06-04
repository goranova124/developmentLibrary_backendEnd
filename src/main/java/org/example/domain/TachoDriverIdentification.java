package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TachoDriverIdentification {
    private String driverIdentification;
    private String cardIssuingMemberState;
    private String driverAuthenticationEquipment;
    private String cardReplacementIndex;
    private String cardRenewalIndex;
}
