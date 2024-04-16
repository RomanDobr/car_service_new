package org.javaacademy.web_homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.web_homework.dto.AnnouncementDto;
import org.javaacademy.web_homework.entity.Announcement;
import org.javaacademy.web_homework.service.AnnouncementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
  private final AnnouncementService announcementService;

  @PostMapping
  public ResponseEntity createAnnouncement(@RequestBody AnnouncementDto announcementDto) {
    announcementService.createAnnouncement(announcementDto);
    return ResponseEntity.status(201).body("Ура создалось");
  }

  @GetMapping
  public Map<Integer, Announcement> getAnnouncements(@RequestParam(required = false) String date,
                                                     @RequestParam(required = false) String brand,
                                                     @RequestParam(required = false) String color,
                                                     @RequestParam(required = false) String model,
                                                     @RequestParam(required = false) String price) {
    if (date != null) {
      return announcementService.findAnnouncementsByData(LocalDate.parse(date));
    } else if (brand != null) {
      return announcementService.findAnnouncementByBrand(brand);
    } else if (model != null) {
      return announcementService.findAnnouncementByModel(model);
    } else if (color != null) {
      return announcementService.findAnnouncementByColor(color);
    } else if (price != null) {
      return announcementService.findAnnouncementByPrice(price);
    } else if ((brand != null) && (color != null)) {
      return announcementService.findAnnouncementByBrandAndColor(brand, color);
    } else if ((brand != null) && (model != null)) {
      return announcementService.findAnnouncementByBrandAndModel(brand, model);
    } else if ((brand != null) && (price != null)) {
      return announcementService.findAnnouncementByBrandAndPrice(brand, price);
    } else if ((color != null) && (model != null)) {
      return announcementService.findAnnouncementByColorAndModel(color, model);
    } else if ((color != null) && (price != null)) {
      return announcementService.findAnnouncementByColorAndPrice(color, price);
    } else if ((model != null) && (price != null)) {
      return announcementService.findAnnouncementByModelAndPrice(model, price);
    } else if ((brand != null) && (color != null) && (price != null)) {
      return announcementService.findAnnouncementByBrandAndColorAndPrice(brand, color, price);
    } else if ((brand != null) && (color != null) && (model != null)) {
      return announcementService.findAnnouncementByBrandAndColorAndModel(brand, color, model);
    } else if ((color != null) && (price != null) && (model != null)) {
      return announcementService.findAnnouncementByColorAndPriceAndModel(color, price, model);
    } else if ((brand != null) && (model != null) && (price != null)) {
      return announcementService.findAnnouncementByBrandAndModelAndPrice(brand, model, price);
    } else if ((brand != null) && (color != null) && (model != null) && (price != null)) {
      return announcementService.findAnnouncementByBrandAndColorAndModelAndPrice(brand, color, model, price);
    }
    return announcementService.findAnnouncementAll();
  }

  @GetMapping("/{filter}")
  public Announcement getAnnouncement(@RequestParam(required = false) Integer id) {
    if (id == null) {
      return announcementService.findAnnouncementByIdNull();
    }
      return announcementService.findAnnouncementById(id);
  }

  @DeleteMapping
    public void deleteAnnouncementById(@RequestParam(required = false) String id) {
    if (id == null) {
      announcementService.deleteAnnouncementAll();
      return;
    }
    announcementService.deleteAnnouncementById(Integer.valueOf(id));
  }
}
