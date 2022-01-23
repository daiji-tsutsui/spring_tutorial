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
    this.userId = userId;
    this.params = params;
    this.token = (token == null || token.length() == 0) ? createToken() : token;
  }

  private String createToken() {
    Integer length = 16;
    String alphaNumerics = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                            + "abcdefghijklmnopqrstuvwxyz"
                            + "0123456789";
    String hashed = "";

    for (int i = 0; i < length; i++) {
      int index = (int)(alphaNumerics.length() * Math.random());
      hashed += alphaNumerics.charAt(index);
    }

    return hashed;
  }

}
