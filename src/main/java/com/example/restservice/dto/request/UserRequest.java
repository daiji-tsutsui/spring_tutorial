package com.example.restservice.dto.request;

import lombok.Data;

@Data
public class UserRequest {

    private Integer id;
    private String name;
    private String password;

}
