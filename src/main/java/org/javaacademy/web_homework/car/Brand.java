package org.javaacademy.web_homework.car;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Brand {
  CHERY("Chery"),
  CHEVROLET("Chevrolet"),
  HYUNDAI("Hyundai");

  private String name;
}
