package com.lleclerc.app.codegen.model;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class JavaClass {
    String packageName;
    String className;
    @Singular
    List<JavaProperty> properties;
}
