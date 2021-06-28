package com.lleclerc.app.codegen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// Generated on 2021-06-27T23:19:00
@Value
public class User {
    @JsonProperty("id")
    Long id;
    @JsonProperty("username")
    String username;
    @JsonProperty("firstName")
    String firstName;
    @JsonProperty("lastName")
    String lastName;
    @JsonProperty("email")
    String email;
    @JsonProperty("password")
    String password;
    @JsonProperty("phone")
    String phone;
    @JsonProperty("userStatus")
    Integer userStatus;
  }
