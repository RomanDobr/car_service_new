package org.javaacademy.web_homework.repository;

import lombok.extern.slf4j.Slf4j;
import org.javaacademy.web_homework.entity.Announcement;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
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

  public void deleteAnnouncementById(Integer id) {
    announcements.remove(id);
  }

  public void deleteAnnouncementAll() {
    announcements.clear();
  }

  public Map<Integer, Announcement> getAnnouncementByParams(List<String> params) {
    return announcements.entrySet().stream()
            .filter(key -> (key.getValue()
                    .getBrand().equals(params.get(0)) || key.getValue()
                    .getColor().equals(params.get(1)) || key.getValue()
                    .getModel().equals(params.get(2))) || key.getValue()
                    .getPrice().equals(params.get(3)))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));
  }
}
