package org.javaacademy.web_homework.car;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Color {
  RED("Red"),
  GREEN("Green"),
  BLUE("Blue"),
  BLACK("Black"),
  OTHER("Color");

  private final String color;
}
