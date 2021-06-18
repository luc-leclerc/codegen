package com.lleclerc.app.codegen.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class JavaEnumElement {
    String name;
}
