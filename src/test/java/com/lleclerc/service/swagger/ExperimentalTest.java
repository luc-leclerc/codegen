package com.lleclerc.service.swagger;

import com.lleclerc.service.yml.YamlUtil;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class ExperimentalTest implements ResourceUtil {
    @Test
    public void getSampleOpenApiV3Model() {
        // GIVEN
        InputStream is = readResource("swagger-pet-sample.yml");

        // WHEN
        OpenapiV3Model model1 = YamlUtil.parseYaml_jackson(is, OpenapiV3Model.class);

        // THEN
        assertEquals("3.0.0", model1.getOpenapi());
    }
}