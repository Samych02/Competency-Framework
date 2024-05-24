package esi.competencyframework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Competency {
  private int id;
  private String name;
  private String description;
  private String domain;
  private String level;

  public Competency(String name, String description, String domain, String level) {
    this.name = name;
    this.description = description;
    this.domain = domain;
    this.level = level;
  }
}
