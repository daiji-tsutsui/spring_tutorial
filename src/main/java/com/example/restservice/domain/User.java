package com.example.restservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.example.restservice.dto.request.UserRequest;

@Data
@Table("users")
public class User {

  @Id
  private Integer id;
  private String name;
  private String password;

  public User(Integer id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
  }

}
