package org.javaacademy.web_homework.repository;

import org.javaacademy.web_homework.car.Brand;
import org.javaacademy.web_homework.car.Color;
import org.javaacademy.web_homework.car.Model;
import org.javaacademy.web_homework.entity.Announcement;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class AnnouncementRepository {
  private Integer countId = 1000;
  private Map<Integer, Announcement> announcements = new HashMap<>();

  public void add(Announcement announcement) {
    countId++;
    announcements.put(countId, announcement);
  }

  public Map<Integer, Announcement> getAnnouncementsByDate(LocalDate date) {
    return announcements.entrySet().stream().filter(key -> key.getValue().getDate().isEqual(date))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));
  }

  public Map<Integer, Announcement> getAnnouncementsByBrand(String brand) {
    return announcements.entrySet().stream().filter(key -> key.getValue().getBrand().equals(helperBrand(brand)))
              .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));
  }

  public Map<Integer, Announcement> getAnnouncementsByModel(String model) {
    return announcements.entrySet().stream().filter(key -> key.getValue().getModel().equals(helperModel(model)))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));
  }

  public Map<Integer, Announcement> getAnnouncementsByColor(String color) {
    return announcements.entrySet().stream().filter(key -> key.getValue().getColor().equals(helperColor(color)))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));
  }

  public Map<Integer, Announcement> getAnnouncementsByPrice(String price) {
    return announcements.entrySet().stream().filter(key -> key.getValue().getPrice().equals(Long.parseLong(price)))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));
  }

  public Announcement getAnnouncementsById(Integer id) {
    return announcements.get(id);
  }

  public Map<Integer, Announcement> getAnnouncements() {
    return announcements;
  }

  public Announcement getAnnouncementsByNull() {
    Integer minIndex = announcements.keySet().stream().min(Integer::compare).orElseThrow();
    return announcements.get(minIndex);
  }

  public Map<Integer, Announcement> getAnnouncementByBrandAndColor(String brand, String color) {
    return announcements.entrySet().stream()
            .filter(key -> (key.getValue()
                    .getBrand().equals(helperBrand(brand)) && key.getValue()
                    .getColor().equals(helperColor(color))))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));
  }

  public Map<Integer, Announcement> getAnnouncementByBrandAndModel(String brand, String model) {
    return announcements.entrySet().stream()
            .filter(key -> (key.getValue()
                    .getBrand().equals(helperBrand(brand)) && key.getValue()
                    .getModel().equals(helperModel(model))))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));
  }

  public Map<Integer, Announcement> getAnnouncementByBrandAndPrice(String brand, String price) {
    return announcements.entrySet().stream()
            .filter(key -> (key.getValue()
                    .getBrand().equals(helperBrand(brand)) && key.getValue()
                    .getPrice().equals(Long.parseLong(price))))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));
  }

  public Map<Integer, Announcement> getAnnouncementByColorAndModel(String color, String model) {
    return announcements.entrySet().stream()
            .filter(key -> (key.getValue()
                    .getColor().equals(helperColor(color)) && key.getValue()
                    .getModel().equals(helperModel(model))))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));
  }

  public Map<Integer, Announcement> getAnnouncementByColorAndPrice(String color, String price) {
    return announcements.entrySet().stream()
            .filter(key -> (key.getValue()
                    .getColor().equals(helperColor(color)) && key.getValue()
                    .getPrice().equals(Long.parseLong(price))))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));
  }

  public Map<Integer, Announcement> getAnnouncementByModelAndPrice(String model, String price) {
    return announcements.entrySet().stream()
            .filter(key -> (key.getValue()
                    .getModel().equals(helperModel(model)) && key.getValue()
                    .getPrice().equals(Long.parseLong(price))))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));
  }

  public Map<Integer, Announcement> getAnnouncementByBrandAndColorAndPrice(String brand, String color, String price) {
    return announcements.entrySet().stream()
            .filter(key -> (key.getValue()
                    .getBrand().equals(helperBrand(brand)) && key.getValue()
                    .getColor().equals(helperColor(color)) && key.getValue()
                    .getPrice().equals(Long.parseLong(price))))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));
  }

  public Map<Integer, Announcement> getAnnouncementByBrandAndColorAndModel(String brand, String color, String model) {
    return announcements.entrySet().stream()
            .filter(key -> (key.getValue()
                    .getBrand().equals(helperBrand(brand)) && key.getValue()
                    .getColor().equals(helperColor(color)) && key.getValue()
                    .getModel().equals(helperModel(model))))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));
  }

  public Map<Integer, Announcement> getAnnouncementByColorAndPriceAndModel(String color, String price, String model) {
    return announcements.entrySet().stream()
            .filter(key -> (key.getValue()
                    .getColor().equals(helperColor(color)) && key.getValue()
                    .getPrice().equals(Long.parseLong(price)) && key.getValue()
                    .getModel().equals(helperModel(model))))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));
  }

  public Map<Integer, Announcement> getAnnouncementByBrandAndModelAndPrice(String brand, String model, String price) {
    return announcements.entrySet().stream()
            .filter(key -> (key.getValue()
                    .getBrand().equals(helperBrand(brand)) && key.getValue()
                    .getModel().equals(helperModel(model)) && key.getValue()
                    .getPrice().equals(Long.parseLong(price))))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));
  }

  public Map<Integer, Announcement> getAnnouncementByBrandAndColorAndModelAndPrice(String brand, String color, String model, String price) {
    return announcements.entrySet().stream()
            .filter(key -> (key.getValue()
                    .getBrand().equals(helperBrand(brand)) && key.getValue()
                    .getColor().equals(helperColor(color)) && key.getValue()
                    .getModel().equals(helperModel(model)) && key.getValue()
                    .getPrice().equals(Long.parseLong(price))))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));
  }

  public void deleteAnnouncementById(Integer id) {
    announcements.remove(id);
  }

  public void deleteAnnouncementAll() {
    announcements.clear();
  }

  private Brand helperBrand(String inBrand) {
    return Arrays.stream(Brand.values()).toList().stream()
            .filter(brand -> brand.getName().equalsIgnoreCase(inBrand))
            .findFirst().orElseThrow();
  }

  private Model helperModel(String inModel) {
    return Arrays.stream(Model.values()).toList().stream()
            .filter(model -> model.getName().equalsIgnoreCase(inModel))
            .findFirst().orElseThrow();
  }

  private Color helperColor(String inColor) {
    return Arrays.stream(Color.values()).toList().stream()
            .filter(color -> color.getColor().equalsIgnoreCase(inColor))
            .findFirst().orElseThrow();
  }
}
