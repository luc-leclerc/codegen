package com.lleclerc.app.codegen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// Generated on 2021-07-01T13:14:42
@Value
public class ApiResponse {
    @JsonProperty("code")
    Integer code;
    @JsonProperty("type")
    String type;
    @JsonProperty("message")
    String message;
  }
