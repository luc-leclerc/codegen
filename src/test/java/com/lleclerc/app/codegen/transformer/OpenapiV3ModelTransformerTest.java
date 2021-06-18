package com.lleclerc.app.codegen.transformer;

import com.lleclerc.service.java.ResourceUtil;
import com.lleclerc.service.swagger.OpenapiV3Model;
import com.lleclerc.service.yml.YamlUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OpenapiV3ModelTransformerTest implements ResourceUtil {
    @Test
    public void transform() {
        // GIVEN
        OpenapiV3Model model = YamlUtil.parseYaml_jackson(readResource("../swagger-pet-sample.yml"), OpenapiV3Model.class);

        // WHEN
        OpenapiV3ModelTransformer.transform(model);

        // THEN
        assertEquals("3.0.0", model.getOpenapi());
    }
}
