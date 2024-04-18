package org.javaacademy.web_homework.dto;

import lombok.Value;
import java.time.LocalDate;

@Value
public class AnnouncementDto {
  String brand;
  String model;
  String price;
  String color;
  LocalDate date;
}
