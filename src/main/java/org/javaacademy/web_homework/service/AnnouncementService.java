package org.javaacademy.web_homework.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.web_homework.dto.AnnouncementDto;
import org.javaacademy.web_homework.entity.Announcement;
import org.javaacademy.web_homework.repository.AnnouncementRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class AnnouncementService {

  private final AnnouncementRepository announcementRepository;

  public void createAnnouncement(AnnouncementDto announcementDto) {
    LocalDate date = announcementDto.getDate() == null ? LocalDate.now() : announcementDto.getDate();
    Announcement announcement = new Announcement(
                             announcementDto.getBrand(),
                             announcementDto.getModel(),
                             announcementDto.getPrice(),
                             announcementDto.getColor(),
                             date);
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



  public void deleteAnnouncementById(Integer id) {
    announcementRepository.deleteAnnouncementById(id);
  }

  public void deleteAnnouncementAll() {
    announcementRepository.deleteAnnouncementAll();
  }

    public Map<Integer, Announcement> findAnnouncementsByParams(List<String> params) {
      return announcementRepository.getAnnouncementByParams(params);
  }
}
