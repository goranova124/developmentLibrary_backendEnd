package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriveridObject {
   private TachoDriverIdentification tachoDriverIdentification;
   private OemDriverIdentification oemDriverIdentification;
}
