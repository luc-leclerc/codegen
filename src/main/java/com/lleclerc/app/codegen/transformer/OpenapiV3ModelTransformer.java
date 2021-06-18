package com.lleclerc.app.codegen.transformer;

import com.lleclerc.app.codegen.model.JavaClass;
import com.lleclerc.service.swagger.OpenapiV3Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface OpenapiV3ModelTransformer {

    static List<Object> transform(OpenapiV3Model openapi) {
        List<Object> result = new ArrayList<>();
        for (Map.Entry<String, OpenapiV3Model.SchemaObject> schema : openapi.getComponents().getSchemas().entrySet()) {
            result.add(transformToModel(schema.getKey(), schema.getValue()));
        }
        return result;
    }

    static Object transformToModel(String name, OpenapiV3Model.SchemaObject schema) {
        JavaClass javaClass = JavaClass.builder()
                .className(name)
                .packageName("").property(null).build();
        return javaClass;
    }
}
