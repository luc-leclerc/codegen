package com.lleclerc.app.codegen.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class JavaClassProperty {
    String propertyName;
    String type;
    String defaultValue;
}
