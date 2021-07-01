package com.lleclerc.app.codegen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// Generated on 2021-07-01T13:14:42
@Value
public class Pet {
    @JsonProperty("id")
    Long id;
    @JsonProperty("category")
    Category category;
    @JsonProperty("name")
    String name;
    @JsonProperty("photoUrls")
    List<String> photoUrls;
    @JsonProperty("tags")
    List<Tag> tags;
    @JsonProperty("status")
    String status;
  }
