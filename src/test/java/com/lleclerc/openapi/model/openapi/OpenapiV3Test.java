package com.lleclerc.openapi.model.openapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.lleclerc.openapi.model.OpenapiV3Model;
import lombok.SneakyThrows;
import org.junit.Ignore;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class OpenapiV3Test {

    final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
    final InputStream sampleYaml = OpenapiV3Test.class.getClassLoader().getResourceAsStream("sample.yml");

    @Test
    @Ignore("TODO complete this test")
    @SneakyThrows
    public void serializeAndDeserialize_works() {
//        JsonNode node = objectMapper.readValue(sampleYaml, JsonNode.class);
        OpenapiV3Model openapiV3 = objectMapper.readValue(sampleYaml, OpenapiV3Model.class);

        String serializedContent = objectMapper.writeValueAsString(openapiV3);
        System.out.println(serializedContent);
        OpenapiV3Model secondDeserialization = objectMapper.readValue(serializedContent, OpenapiV3Model.class);

        // TODO
        // secondDeserialization == openapiV3
    }
}