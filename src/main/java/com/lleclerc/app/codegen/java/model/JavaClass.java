package com.lleclerc.app.codegen.java.model;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class JavaClass {
    String className;
    String packageName;
    @Singular
    List<JavaClassProperty> properties;
}
