package org.javaacademy.web_homework.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.web_homework.car.Brand;
import org.javaacademy.web_homework.car.Color;
import org.javaacademy.web_homework.car.Model;
import org.javaacademy.web_homework.dto.AnnouncementDto;
import org.javaacademy.web_homework.entity.Announcement;
import org.javaacademy.web_homework.repository.AnnouncementRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class AnnouncementService {

  private final AnnouncementRepository announcementRepository;

  public void createAnnouncement(AnnouncementDto announcementDto) {
    LocalDate date = announcementDto.getDate() == null ? LocalDate.now() : announcementDto.getDate();
    Brand brandDto = helperBrandDto(announcementDto.getBrand());
    Model modelDto = helperModelDto(announcementDto.getModel());
    Color colorDto = helperColorDto(announcementDto.getColor());
    Announcement announcement =
            new Announcement(brandDto, modelDto, announcementDto.getPrice(), colorDto, date);
    announcementRepository.add(announcement);
  }

  public Announcement findAnnouncementById(Integer id) {
    System.out.println(id);
    return announcementRepository.getAnnouncementsById(id);
  }

  public Map<Integer, Announcement> findAnnouncementsByData(LocalDate date) {
    return announcementRepository.getAnnouncementsByDate(date);
  }

  public Map<Integer, Announcement> findAnnouncementAll() {
    return announcementRepository.getAnnouncements();
  }

  public Announcement findAnnouncementByIdNull() {
    return announcementRepository.getAnnouncementsByNull();
  }

  public Map<Integer, Announcement> findAnnouncementByBrand(String brand) {
    return announcementRepository.getAnnouncementsByBrand(brand);
  }

  public Map<Integer, Announcement> findAnnouncementByModel(String model) {
    return announcementRepository.getAnnouncementsByModel(model);
  }

  public Map<Integer, Announcement> findAnnouncementByColor(String color) {
    return announcementRepository.getAnnouncementsByColor(color);
  }

  public Map<Integer, Announcement> findAnnouncementByPrice(String price) {
    return  announcementRepository.getAnnouncementsByPrice(price);
  }

  public Map<Integer, Announcement> findAnnouncementByBrandAndColor(String brand, String color) {
    return announcementRepository.getAnnouncementByBrandAndColor(brand, color);
  }

  public Map<Integer, Announcement> findAnnouncementByBrandAndModel(String brand, String model) {
    return announcementRepository.getAnnouncementByBrandAndModel(brand, model);
  }

  public Map<Integer, Announcement> findAnnouncementByBrandAndPrice(String brand, String price) {
    return announcementRepository.getAnnouncementByBrandAndPrice(brand, price);
  }

  public Map<Integer, Announcement> findAnnouncementByColorAndModel(String color, String model) {
    return announcementRepository.getAnnouncementByColorAndModel(color, model);
  }

  public Map<Integer, Announcement> findAnnouncementByColorAndPrice(String color, String price) {
    return announcementRepository.getAnnouncementByColorAndPrice(color, price);
  }

  public Map<Integer, Announcement> findAnnouncementByModelAndPrice(String model, String price) {
    return announcementRepository.getAnnouncementByModelAndPrice(model, price);
  }

  public Map<Integer, Announcement> findAnnouncementByBrandAndColorAndPrice(String brand, String color, String price) {
    return announcementRepository.getAnnouncementByBrandAndColorAndPrice(brand, color, price);
  }

  public Map<Integer, Announcement> findAnnouncementByBrandAndColorAndModel(String brand, String color, String model) {
    return announcementRepository.getAnnouncementByBrandAndColorAndModel(brand, color, model);
  }

  public Map<Integer, Announcement> findAnnouncementByColorAndPriceAndModel(String color, String price, String model) {
    return announcementRepository.getAnnouncementByColorAndPriceAndModel(color, price, model);
  }

  public Map<Integer, Announcement> findAnnouncementByBrandAndModelAndPrice(String brand, String model, String price) {
    return announcementRepository.getAnnouncementByBrandAndModelAndPrice(brand, model, price);
  }

  public Map<Integer, Announcement> findAnnouncementByBrandAndColorAndModelAndPrice(String brand, String color, String model, String price) {
    return announcementRepository.getAnnouncementByBrandAndColorAndModelAndPrice(brand, color, model, price);
  }

  public void deleteAnnouncementById(Integer id) {
    announcementRepository.deleteAnnouncementById(id);
  }

  public void deleteAnnouncementAll() {
    announcementRepository.deleteAnnouncementAll();
  }

  private Brand helperBrandDto(String brandDto) {
    if (brandDto == null) {
      throw new RuntimeException("Отсутствует наименование бренда!");
    }
    return Arrays.stream(Brand.values()).toList().stream()
            .filter(brand -> brand.getName().equalsIgnoreCase(brandDto))
            .findFirst().orElseThrow();
  }

  private Model helperModelDto(String modelDto) {
    if (modelDto == null) {
      throw new RuntimeException("Отсутствует наименование модели!");
    }
    return Arrays.stream(Model.values()).toList().stream()
            .filter(model -> model.getName().equalsIgnoreCase(modelDto))
            .findFirst().orElseThrow();
  }

  private Color helperColorDto(String colorDto) {
    if (colorDto == null || colorDto.length() == 0) {
      return Color.BLACK;
    }
    return Arrays.stream(Color.values()).toList().stream()
            .filter(color -> color.getColor().equalsIgnoreCase(colorDto))
            .findFirst().orElseThrow();
  }
}
