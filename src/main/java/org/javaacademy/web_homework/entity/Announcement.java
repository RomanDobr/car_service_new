package org.javaacademy.web_homework.entity;

import lombok.Data;
import lombok.NonNull;
import org.javaacademy.web_homework.car.Brand;
import org.javaacademy.web_homework.car.Color;
import org.javaacademy.web_homework.car.Model;
import java.time.LocalDate;

@Data
public class Announcement {

  @NonNull
  private Brand brand;
  @NonNull
  private Model model;
  @NonNull
  private Long price;
  @NonNull
  private Color color;
  @NonNull
  private LocalDate date;
}
