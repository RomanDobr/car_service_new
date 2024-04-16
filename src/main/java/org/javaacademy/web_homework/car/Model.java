package org.javaacademy.web_homework.car;

import lombok.*;

@AllArgsConstructor
@Getter
public enum Model {
  CHERY_TIGGO_3("Chery Tiggo 3"),
  CHERY_OMODA_5("Chery Omoda 5"),
  CHEVROLET_TAHOE("Chevrolet Tahoe"),
  CHEVROLET_COBALT("Chevrolet Cobalt"),
  HYUNDAI_SANTE_FE("Hyundai Santa Fe"),
  HYUNDAI_SOLARIS("Hyundai Solaris");

  private final String name;
}
