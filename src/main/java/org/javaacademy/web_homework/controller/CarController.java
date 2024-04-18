package org.javaacademy.web_homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.web_homework.dto.AnnouncementDto;
import org.javaacademy.web_homework.entity.Announcement;
import org.javaacademy.web_homework.service.AnnouncementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;


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
    }

    if (date == null && brand == null && color == null && model == null && price == null) {
      return announcementService.findAnnouncementAll();
    }

    List<String> params = new LinkedList<>();
    params.add(brand);
    params.add(color);
    params.add(model);
    params.add(price);
    if (params.size() > 0) {
      return announcementService.findAnnouncementsByParams(params);
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
