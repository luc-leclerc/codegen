package com.lleclerc.app.codegen.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class JavaProperty {
    String propertyName;
    String propertyNameSafe;
    String type;
    String defaultValue;
}
