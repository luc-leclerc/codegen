package com.lleclerc.app.codegen.model;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class JavaEnum {
    String enumName;
    String packageName;
    @Singular
    List<JavaEnumElement> elements;
}
