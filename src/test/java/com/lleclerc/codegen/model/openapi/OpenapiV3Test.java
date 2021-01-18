package com.lleclerc.codegen.model.openapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
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
        OpenapiV3 openapiV3 = objectMapper.readValue(sampleYaml, OpenapiV3.class);

        String serializedContent = objectMapper.writeValueAsString(openapiV3);
        System.out.println(serializedContent);
        OpenapiV3 secondDeserialization = objectMapper.readValue(serializedContent, OpenapiV3.class);

        // TODO
        // secondDeserialization == openapiV3
    }
}