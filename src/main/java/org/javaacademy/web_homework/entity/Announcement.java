package org.javaacademy.web_homework.entity;

import lombok.Data;
import lombok.NonNull;
import java.time.LocalDate;

@Data
public class Announcement {

  @NonNull
  private String brand;
  @NonNull
  private String model;
  @NonNull
  private String price;
  @NonNull
  private String color;
  @NonNull
  private LocalDate date;
}
