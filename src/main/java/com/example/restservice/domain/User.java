package com.example.restservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("users")
public class User {

  @Id
  private int id;
  private String name;
  private String password;

  public User(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

}
