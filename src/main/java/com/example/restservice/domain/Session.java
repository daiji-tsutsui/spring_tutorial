package com.example.restservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("sessions")
public class Session {

  @Id
  private Integer id;
  private String token;
  private Integer userId;
  private String params;

  public Session(Integer id, String token, Integer userId, String params) {
    this.id = id;
    this.token = token;
    this.userId = userId;
    this.params = params;
  }

}
