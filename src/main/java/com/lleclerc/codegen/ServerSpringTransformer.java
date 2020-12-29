package com.lleclerc.codegen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ServerSpringTransformer {
    String FROM_TAGS = "tags";
    String FROM_PATHS = "paths";

    default Map<String, Object> toMustacheModel(Map<String, Object> openApiModel) {
        Map<String, Object> result = new HashMap<>();

        result.put("Controller", null);
        result.put("Enum", null);
        result.put("Model", null);


        List<Map> tags = (List) openApiModel.get(FROM_TAGS);
        Map paths = (Map) openApiModel.get(FROM_PATHS);

        if (paths == null || paths.size() == 0) {
            System.out.println("no path found");
        }

        return result;
    }
}
