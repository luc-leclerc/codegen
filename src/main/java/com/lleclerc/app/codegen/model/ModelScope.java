package com.lleclerc.app.codegen.model;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class ModelScope {
    String packageName;
    String className;
    List<ModelScopeProperty> properties = new ArrayList<>();

    @Value
    public static class ModelScopeProperty {
        String propertyName;
        String propertyNameSafe;
        String type;
        String defaultValue;
    }
}
