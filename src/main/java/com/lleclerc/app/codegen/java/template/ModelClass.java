package com.lleclerc.app.codegen.java.template/*{{{packageName}}}*/;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// Generated on {{{now}}}
@Value
public class ModelClass/*{{{className}}}*/ {
    /*{{#properties}}*/
    @JsonProperty("{{{propertyName}}}")
    LocalDateTime/*{{{type}}}*/ propertySafeJava/*{{{propertyName_safeJava}}}*/;
    /*{{/properties}}*/ List<LocalDate>/*{{empty}}*/ localDate;/*{{empty}}*/
}