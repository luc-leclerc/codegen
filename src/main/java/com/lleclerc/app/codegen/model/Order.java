package com.lleclerc.app.codegen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// Generated on 2021-06-27T23:19:00
@Value
public class Order {
    @JsonProperty("id")
    Long id;
    @JsonProperty("petId")
    Long petId;
    @JsonProperty("quantity")
    Integer quantity;
    @JsonProperty("shipDate")
    LocalDateTime shipDate;
    @JsonProperty("status")
    String status;
    @JsonProperty("complete")
    Boolean complete;
  }
